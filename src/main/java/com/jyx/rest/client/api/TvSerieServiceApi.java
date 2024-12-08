package com.jyx.rest.client.api;

import com.jyx.rest.client.models.TvSerie;
import io.quarkus.rest.client.reactive.ClientExceptionMapper;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("/singlesearch")
@RegisterRestClient
@ApplicationScoped
public interface TvSerieServiceApi {

    @GET
    @Path("/shows")
    @Produces(MediaType.APPLICATION_JSON)
    TvSerie getSeriesByTitle(@QueryParam("q") String title);

    @ClientExceptionMapper
    static RuntimeException toException(Response response) {
        if (response.getStatus() == 400) {
            return new RuntimeException("Bad Url");
        }

        if (response.getStatus() == 404) {
            return new RuntimeException("No Tv Series");
        }

        if (response.getStatus() == 500) {
            return new RuntimeException("The remote service responded with HTTP 500");
        }
        return null;
    }
}
