package com.psiphiglobal.identity.endpoints;

import com.psiphiglobal.identity.model.Certificate;
import com.psiphiglobal.identity.service.CertificateService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/cert/{cert_id}")
public class CertificateEndpoint extends AbstractEndpoint
{
    private CertificateService certificateService;

    public CertificateEndpoint()
    {
        super();
        certificateService = new CertificateService();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public void fetchCertificate(@PathParam("cert_id") String certId, @Suspended AsyncResponse asyncResponse)
    {
        workerPool.execute(() ->
        {
            Certificate cert = certificateService.fetchCertificate(certId);
            if (cert != null)
                asyncResponse.resume(buildSuccessJsonResponse(cert));
            else
                asyncResponse.resume(Response.status(Response.Status.NOT_FOUND).build());
        });
    }
}
