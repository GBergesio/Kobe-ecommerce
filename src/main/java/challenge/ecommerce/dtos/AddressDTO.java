package challenge.ecommerce.dtos;

import challenge.ecommerce.models.Address;
import lombok.Data;

@Data
public class AddressDTO {

    private long id;

    private Long zipCode;

    private Long streetNumber;

    private String floorApartment;

    private String streetName;

    private String province;

    private String locality;

    public AddressDTO(){}
    public AddressDTO(Address address) {
        this.id = address.getId();
        this.zipCode = address.getZipCode();
        this.streetNumber = address.getStreetNumber();
        this.floorApartment = address.getFloorApartment();
        this.streetName = address.getStreetName();
        this.province = address.getProvince();
        this.locality = address.getLocality();
    }
}
