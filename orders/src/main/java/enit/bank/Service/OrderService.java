import java.util.Map;

import javax.persistence.criteria.Order;

import enit.bank.Models.Cart;

public interface OrderService {
    public Cart getCart(Long idCart);

    public Order saveOrder(Cart cart);

    public double getPrice(Map<Long, Integer> prods);

}