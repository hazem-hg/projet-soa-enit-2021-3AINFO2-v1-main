package org.enit.ecommerce.mailiing;

import io.quarkus.mailer.Mail;
import io.quarkus.mailer.MockMailbox;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;

@QuarkusTest
class MailerResourceTest {

    private static final String TO = "aymen.bettaieb@etudiant-enit.utm.tn";

    @Inject
    MockMailbox mailbox;

    @BeforeEach
    void init() {
        mailbox.clear();
    }

    @Test
    void testMail() {
        given()
                .queryParam("Aymen", "oooo")
                .queryParam("email", TO)
                .when()
                .get("/type-safe")
                .then()
                .statusCode(202);

        // verify that it was sent
        List<Mail> sent = mailbox.getMessagesSentTo(TO);
        assertThat(sent).hasSize(1);
        Mail actual = sent.get(0);
        assertThat(actual.getHtml()).contains("Welcome");
        assertThat(actual.getSubject()).isEqualTo("ooo");

        assertThat(mailbox.getTotalMessagesSent()).isEqualTo(1);
    }


 
}