package com.psiphiglobal.identity.endpoints;

import com.psiphiglobal.identity.model.Certificate;
import com.psiphiglobal.identity.service.CertificateService;

import javax.ws.rs.*;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.HashMap;
import java.util.Map;

@Path("/{domain_name}")
public class DomainEndpoint extends AbstractEndpoint
{
    private CertificateService certificateService;

    public DomainEndpoint()
    {
        super();
        certificateService = new CertificateService();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public void fetchPrimaryCertificate(@PathParam("domain_name") String domainName, @Suspended AsyncResponse asyncResponse)
    {
        workerPool.execute(() ->
        {
            Certificate cert = certificateService.fetchActiveCertificate(domainName);
            if (cert != null)
                asyncResponse.resume(buildSuccessJsonResponse(cert));
            else
                asyncResponse.resume(Response.status(Response.Status.NOT_FOUND).build());
        });
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public void init(@PathParam("domain_name") String domainName, String inputJson, @Suspended AsyncResponse asyncResponse)
    {
        workerPool.execute(() ->
        {
            // Parse Input Json
            Map<String, String> input = null;
            try
            {
                input = parseInput(inputJson);
            }
            catch (Exception e)
            {
                asyncResponse.resume(Response.status(Response.Status.BAD_REQUEST).build());
                return;
            }

            String orgName = input.get("org_name");
            String orgCountry = input.get("org_country");
            String orgEmail = input.get("org_email");
            String publicKeyAlgo = input.get("public_key_algo");
            String publicKey = input.get("public_key");
            String roleType = input.get("role");

            try
            {
                String token = certificateService.initiateRegistration(domainName, orgName, orgEmail, orgCountry, publicKeyAlgo, publicKey, roleType);
                Map<String, String> response = new HashMap<>();
                response.put("cert_id", token);
                asyncResponse.resume(buildSuccessJsonResponse(response));
            }
            catch (CertificateService.InvalidPublicKeyException | CertificateService.InvalidDomainException |
                    CertificateService.InvalidCountryException | CertificateService.InvalidOrgNameException |
                    CertificateService.InvalidEmailException e)
            {
                asyncResponse.resume(Response.status(Response.Status.BAD_REQUEST).build());
                return;
            }
        });
    }

    @Path("self-sign")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public void selfSign(@PathParam("domain_name") String domainName, String inputJson, @Suspended AsyncResponse asyncResponse)
    {
        workerPool.execute(() ->
        {
            // Parse Input Json
            Map<String, String> input = null;
            try
            {
                input = parseInput(inputJson);
            }
            catch (BadRequestException e)
            {
                asyncResponse.resume(Response.status(Response.Status.BAD_REQUEST).build());
                return;
            }

            String certId = input.get("cert_id");
            String signature = input.get("signature");
            String autoVerificationMechanism = input.get("auto_verification_mechanism");

            try
            {
                String txId = certificateService.completeRegistration(domainName, certId, signature, autoVerificationMechanism);
                Map<String, String> response = new HashMap<>();
                response.put("blockchain_tx_id", txId);
                asyncResponse.resume(buildSuccessJsonResponse(response));
            }
            catch (CertificateService.InvalidDomainException | CertificateService.InvalidCertIdException e)
            {
                asyncResponse.resume(Response.status(Response.Status.BAD_REQUEST).build());
                return;
            }
            catch (CertificateService.InvalidSignatureException | CertificateService.AutoValidationException e)
            {
                asyncResponse.resume(Response.status(Response.Status.UNAUTHORIZED).build());
                return;
            }
        });
    }
}
