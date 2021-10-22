package enit.cart.service;

//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;

//import javax.persistence.PersistenceException;
//import javax.sql.DataSource;

import enit.cart.domain.entity.*;
import enit.cart.repository.*;

import org.springframework.beans.factory.annotation.Autowired;


public class CartService {
    @Autowired
    CartRepo cartRepo;


    public Cart getCart(Long id){
        Cart c = new Cart();
        c.setCartId(id);
        cartRepo.findById(id).map((cart) -> {
            if(cart.data.size() > 0){
                c.setData(cart.data);
            }
            return c;
        });
        return c;
    }
     public void addToCart(Demande demande) {
		this.data.add(demande);
	}
    public void showCart() {
		ListIterator<Demande> iterator = data.listIterator();
		while(iterator.hasNext()) {
			Demande demande1 = iterator.next();
			System.out.println(demande1);
		}
	}
    
    
}
