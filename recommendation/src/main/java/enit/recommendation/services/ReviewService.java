package enit.recommendation.services;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("/user")
@RegisterRestClient
public interface ReviewService {
   @GET
   @Path("/{id}") 
   List<Review> getUserReviews(@PathParam(value="id") Long id);
}
