package com.jyx.rest.client;


import com.jyx.rest.client.api.TvSerieServiceApi;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.microprofile.rest.client.inject.RestClient;


@Path("/singlesearch")
@ApplicationScoped
@Slf4j
public class TvSerieResource {

    @Inject
    @RestClient
    TvSerieServiceApi api;

    @GET
    @Path("/shows")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getSerie(@QueryParam("q") String title) {
        var response = api.getSeriesByTitle(title);
        return Response.ok(response).build();
    }


}
