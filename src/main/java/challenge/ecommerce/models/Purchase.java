package challenge.ecommerce.models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
public class Purchase {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private Long id;

    private LocalDateTime purchaseDate;

    private String address;

    private Integer zipCode;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="client_id")
    private Client client;

    @OneToMany(mappedBy = "purchase", fetch = FetchType.EAGER)
    private Set<PurchaseProduct> purchaseProducts = new HashSet<>();


    public Purchase(){}
    public Purchase(LocalDateTime purchaseDate, String address, Integer zipCode) {
        this.purchaseDate = purchaseDate;
        this.address = address;
        this.zipCode = zipCode;
    }

    public void addPurchaseProduct(PurchaseProduct purchaseProduct) {
        purchaseProduct.setPurchase(this);
        purchaseProducts.add(purchaseProduct);
    }


}
