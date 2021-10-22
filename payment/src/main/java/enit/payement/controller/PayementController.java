package enit.payement.controller;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import enit.payement.domain.entity.OrderToPay;
import lombok.extern.slf4j.Slf4j;

@Path("payement")
@ApplicationScoped
@Produces("application/json")
@Consumes("application/json")
@Slf4j
public class PayementController {

    @Inject
    @RestClient
    PaymentService paymentService;



    @GET
    @Path("/ordertopay")
    @Transactional
    public Response getOrderToPay(OrderToPay orderToPay){
        if(paymentService.postToBank(orderToPay))
            paymentService.save(orderToPay);
            return Response.ok().status(201).build();
        else
            return Response.serverError().status(403).build();
    }
    
}
