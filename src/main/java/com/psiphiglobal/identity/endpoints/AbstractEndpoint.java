package com.psiphiglobal.identity.endpoints;

import com.google.gson.reflect.TypeToken;
import com.psiphiglobal.identity._core.ServerContext;
import com.psiphiglobal.identity.util.GsonProvider;

import javax.ws.rs.BadRequestException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.lang.reflect.Type;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;

public class AbstractEndpoint
{
    protected ExecutorService workerPool;

    public AbstractEndpoint()
    {
        workerPool = ServerContext.getInstance().getWorkerPool();
    }

    protected Map<String, String> parseInput(String inputJson)
    {
        Map<String, String> input = null;
        try
        {
            Type type = new TypeToken<HashMap<String, String>>()
            {
            }.getType();
            input = GsonProvider.get().fromJson(inputJson, type);

            if (input == null)
                throw new NullPointerException();

            return input;
        }
        catch (Exception e)
        {
            throw new BadRequestException();
        }
    }

    protected Response buildSuccessJsonResponse(Object o)
    {
        return Response.ok(GsonProvider.get().toJson(o), MediaType.APPLICATION_JSON_TYPE).build();
    }

    protected Response buildEmptySuccessResponse()
    {
        return Response.ok().build();
    }

    protected Response redirect(String url)
    {
        try
        {
            return Response.seeOther(new URI(url)).build();
        }
        catch (URISyntaxException e)
        {
            return Response.serverError().build();
        }
    }
}
