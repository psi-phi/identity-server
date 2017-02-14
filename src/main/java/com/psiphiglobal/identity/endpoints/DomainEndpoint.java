package com.psiphiglobal.identity.endpoints;

import com.psiphiglobal.identity.model.Certificate;
import com.psiphiglobal.identity.service.RegistrationService;

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
    private RegistrationService registrationService;

    public DomainEndpoint()
    {
        super();
        registrationService = new RegistrationService();
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

            try
            {
                String token = registrationService.initiate(domainName, orgName, orgEmail, orgCountry, publicKeyAlgo, publicKey);
                Map<String, String> response = new HashMap<>();
                response.put("cert_id", token);
                asyncResponse.resume(buildSuccessJsonResponse(response));
            }
            catch (RegistrationService.InvalidPublicKeyException | RegistrationService.InvalidDomainException |
                    RegistrationService.InvalidCountryException | RegistrationService.InvalidOrgNameException |
                    RegistrationService.InvalidEmailException e)
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
                Certificate certificate = registrationService.complete(domainName, certId, signature, autoVerificationMechanism);
                asyncResponse.resume(buildSuccessJsonResponse(certificate));
            }
            catch (RegistrationService.InvalidDomainException | RegistrationService.InvalidCertIdException e)
            {
                asyncResponse.resume(Response.status(Response.Status.BAD_REQUEST).build());
                return;
            }
            catch (RegistrationService.InvalidSignatureException | RegistrationService.AutoValidationException e)
            {
                asyncResponse.resume(Response.status(Response.Status.UNAUTHORIZED).build());
                return;
            }
        });
    }
}
