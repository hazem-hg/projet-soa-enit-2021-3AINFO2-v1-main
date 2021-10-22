package enit.cart.repository;
import enit.cart.domain.entity.Cart;
import org.springframework.data.repository.CrudRepository;

public interface CartRepo   extends CrudRepository<Cart, Long> {
    
}
