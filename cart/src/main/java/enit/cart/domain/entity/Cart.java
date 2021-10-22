package enit.cart.domain.entity;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
//import javax.persistence.OneToMany;
//import javax.persistence.Table;
//import java.util.Date;
//import java.util.Set;
import java.util.List;
import java.util.ArrayList;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class Cart {
    @Id
    public Long cartId;

    @Column
    public List<Demande> data = new ArrayList<Demande>();

    public void setCartId(Long id){
        this.cartId = id;
    }

    public void setData(List<Demande> data){
        this.data = data;
    }
}
