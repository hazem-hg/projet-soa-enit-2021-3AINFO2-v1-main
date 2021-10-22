package enit.cart.controller;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
//import javax.ws.rs.POST;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import enit.cart.service.*;
import enit.cart.domain.entity.*;
import lombok.extern.slf4j.Slf4j;

//import lombok.extern.slf4j.Slf4j;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;

//import javax.enterprise.context.ApplicationScoped;
//import javax.inject.Inject;
import javax.ws.rs.*;
//import javax.ws.rs.core.MediaType;
//import javax.ws.rs.core.Response;

@Path("cart")
@ApplicationScoped
@Produces("application/json")
@Consumes("application/json")
@Slf4j
public class CartController {
    
    @Inject
    //@RestClient
    CartService cartService;

    @GET
    @Path("/{id}")
    public Response getCart(@PathParam("id") Long id){
        Cart c = cartService.getCart(id);
        if(c.data.size() > 0){
            return Response.ok(cartService.getCart(id)).build();
        }else{
            return Response.status(404).build();
        }
    }


}
