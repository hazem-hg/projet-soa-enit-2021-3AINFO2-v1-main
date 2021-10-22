package enit.recommendation.services;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("/similar")
@RegisterRestClient
public interface SearchService {
    @GET
    @Path("/{name}")
    List<Product> getSimilarProducts(@PathParam(value="name") String name);
}
