package enit.ecommerce;

import io.quarkus.mailer.Mail;
import io.quarkus.mailer.Mailer;
import io.smallrye.common.annotation.Blocking;
import io.smallrye.mutiny.Uni;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/mail")
public class MailResource {

    @Inject
    Mailer mailer;

    @GET
    @Blocking
    public void sendEmail() {
        mailer.send(Mail.withText("aymen.bettaieb@etudiant-enit.utm.tn", "Hello", "An email was sented from a Quarkus app"));
    }



}