package com.psiphiglobal.identity._core;

import com.psiphiglobal.identity.endpoints.CertificateEndpoint;
import com.psiphiglobal.identity.endpoints.DomainEndpoint;
import com.psiphiglobal.identity.endpoints.HealthEndpoint;
import com.psiphiglobal.identity.logging.RequestLogger;
import com.psiphiglobal.identity.logging.ResponseLogger;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

@ApplicationPath(Constants.BASE_URI)
public class Bootstrap extends Application
{
    public Bootstrap()
    {
    }

    @Override
    public Set<Class<?>> getClasses()
    {
        Set<Class<?>> resources = new HashSet<>();

        /* Logger */
        resources.add(RequestLogger.class);
        resources.add(ResponseLogger.class);

        /* Endpoints */
        resources.add(HealthEndpoint.class);
        resources.add(DomainEndpoint.class);
        resources.add(CertificateEndpoint.class);

        /* Error Handler */
        resources.add(DefaultExceptionHandler.class);

        return resources;
    }
}