package enit.recommendation;

import java.util.List;
import java.util.stream.Collectors;  
import java.util.Optional;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import enit.recommendation.services.Product;
import enit.recommendation.services.Review;
import enit.recommendation.services.ReviewService;
import enit.recommendation.services.SearchService;



@Path("/")
public class RecommendationResource {

    @Inject
    @RestClient
    ReviewService reviewService;
    
    @Inject
    @RestClient
    SearchService searchService;

    @GET
    @Path("/{id}")
    public Optional<List<List<Product> >> getRecommendation(@PathParam(value="id") Long id) {
        List<Review> reviews = reviewService.getUserReviews(id);
        
        if (reviews != null):
            List<String> productsNames =  reviews.stream()
                .map(review -> review.getProductName())
                .collect(Collectors.toList());
        
            List<List<Product> > products = asList(asList());     
            for (int i = 0; i < reviews.size(); i++) 
                products.add(searchService.getSimilarProducts(productsNames.get(i)));
    
       return products.orElse(null);     
    }

}