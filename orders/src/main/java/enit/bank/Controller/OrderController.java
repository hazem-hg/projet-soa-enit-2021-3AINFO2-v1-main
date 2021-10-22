package enit.bank.Controller;

import javax.persistence.criteria.Order;
import javax.ws.rs.GET;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import enit.bank.Feign.CartFeign;
import enit.bank.Models.Cart;

@RestController
public class OrderController {
    CartFeign cartFeign;

    @GetMapping(value = "/cart/{idCart}")
    public Cart getCart(@PathVariable(value = "idCart") Long idCart) {
        Cart cart = cartFeign.getCartById(idCart);
        return cart;
    }
}
