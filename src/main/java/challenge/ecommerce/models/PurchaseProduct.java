package challenge.ecommerce.models;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Data
@Entity
public class PurchaseProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private long id;

    private Integer quantity;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="purchase_id")
    private Purchase purchase;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="product_id")
    private Product product;


    public PurchaseProduct(){}
    public PurchaseProduct(Purchase purchase, Product product, Integer quantity){
        this.purchase = purchase;
        this.product = product;
        this.quantity = quantity;
    }
}
