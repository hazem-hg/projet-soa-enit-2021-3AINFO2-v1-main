package enit.bank;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.PUT;
import javax.ws.rs.POST;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

import enit.bank.Domain.Cart;

import java.util.ArrayList;
import java.util.List;

@Path("/api/price")
public class Pricing {
    int id;
    float price;
    float promo;
    public List<Cart> CartList = new ArrayList<Cart>();

    @POST
    @Path("/price/set/new")
    protected void affecterPrix(float price) {
        this.price = price;
    }

    @POST
    @Path("/price/set/maj")
    protected void majPrix(float newPrice) {
        this.price = newPrice;

    }

    @GET
    @Path("/price/product")
    public String getPrixProduit(int idProduit) {
        if (this.id == idProduit) {
            return String.valueOf(this.price);
        } else {
            return ("le produit n'existe pas");
        }
    }

    @POST
    @Path("/promo/set/product")
    protected void ajouterPromoProduit(int idProduit, float newPromo) {
        this.promo = newPromo;
    }

    @POST
    @Path("/promo/maj/product")
    protected void majPromoProduit(float promoMAJ) {
        this.promo = promoMAJ;

    }

    @PUT
    @Path("/promo/activate/product")
    protected void activerPromoProduit(float promo, int idProduit) {
        if (this.id == idProduit) {
            float prixPromo = this.price - (this.price * promo);
            majPrix(prixPromo);
        }
    }

    @DELETE
    @Path("/promo/desactivate/product")
    protected void desactiverPromoProduit(float promo, int idProduit) {
        if (this.id == idProduit) {
            float oldPrice = this.price + (this.price * promo);
            majPrix(oldPrice);
        }

    }

    @POST
    @Path("/promo/set/Categorie")
    protected void ajouterPromoCategorie() {
    }

    @POST
    @Path("/promo/maj/Categorie")
    protected void majPromoCategorie(float promo) {

    }

    @PUT
    @Path("/promo/activate/Categorie")
    protected void activerPromoCategorie() {

    }

    @DELETE
    @Path("/promo/desactivate/Categorie")
    protected void desactiverPromoCategorie() {

    }

    @GET
    @Path("/price/total")
    public float getPrixTotal(int id, int quantity) {
        return price * quantity;
    }

    // pour calculer prix total d'une panier
    @GET
    @Path("/price/totalCart")

    public float getPrixTotalCart(int id, List<Cart> cartList) {
        float total = 0;
        for (int i = 0; i < cartList.size(); i++) {

            price = cartList.getPrice();
            total = total + price;

        }
        return total;
    }

    /**
     * @return int return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return float return the price
     */
    public float getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(float price) {
        this.price = price;
    }

    /**
     * @return float return the promo
     */
    public float getPromo() {
        return promo;
    }

    /**
     * @param promo the promo to set
     */
    public void setPromo(float promo) {
        this.promo = promo;
    }

}