package enit.bank.controller;

import enit.bank.domain.entity.AccountTransaction;
import enit.bank.domain.entity.BankAccount;
import enit.bank.domain.resource.ClientTransaction;
import enit.bank.service.BankService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("bank")
@ApplicationScoped
@Slf4j
public class BankController {
    @Inject
    BankService bankService;

    @POST
    @Path("/transaction/make/{accountno}")
    @Transactional
    @Consumes("application/json")
    @Produces(MediaType.TEXT_PLAIN)
    public Response MakeTransaction(@PathParam Long code, AccountTransaction accountTransaction) {
        BankAccount ba = bankService.getAccount(code)
        bankService.MakeTransaction(accountTransaction);
        ba.getAccountTransactionSet().add(accountTransaction);
        bankService.CreateAccount(ba);
        return Response.ok(accountTransaction).status(201).build();
    }

    @POST
    @Path("/account/make")
    @Transactional
    @Consumes("application/json")
    @Produces(MediaType.TEXT_PLAIN)
    public String MakeAccount(BankAccount bankAccount) {
        bankService.CreateAccount(bankAccount);
        return bankAccount.toString();
    }
    @GET
    @Path("/testresource")
    @Produces(MediaType.TEXT_PLAIN)
    public String test(ClientTransaction c){
        return c.toString();
    }

}
