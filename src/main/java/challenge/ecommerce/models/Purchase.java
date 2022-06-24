package challenge.ecommerce.models;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
public class Purchase {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private long id;

    private LocalDateTime purchaseDate;

    private String address;

    private int zipCode;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="client_id")
    private Client client;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="product_id")
    private Product product;

    public Purchase(){};
    public Purchase(LocalDateTime purchaseDate, String address, int zipCode, Client client, Product product) {
        this.purchaseDate = purchaseDate;
        this.address = address;
        this.zipCode = zipCode;
        this.client = client;
        this.product = product;
    }


}
