package challenge.ecommerce.models;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Data
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private long id;

    private long zipCode, streetNumber;

    private String floorApartment, streetName, province, locality;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="client_id")
    private Client client;

    public Address(){}
    public Address(long zipCode, long streetNumber, String floorApartment, String streetName, String province, String locality) {
        this.zipCode = zipCode;
        this.streetNumber = streetNumber;
        this.floorApartment = floorApartment;
        this.streetName = streetName;
        this.province = province;
        this.locality = locality;
    }
}
