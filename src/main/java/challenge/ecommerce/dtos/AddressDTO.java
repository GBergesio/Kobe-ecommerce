package challenge.ecommerce.dtos;

import challenge.ecommerce.models.Address;
import lombok.Data;
import lombok.Getter;

@Data
public class AddressDTO {

    private long id;

    private long zipCode, streetNumber;

    private String floorApartment, streetName, province, locality;

    public AddressDTO(){}
    public AddressDTO(Address address) {
        this.zipCode = address.getZipCode();
        this.streetNumber = address.getStreetNumber();
        this.floorApartment = address.getFloorApartment();
        this.streetName = address.getStreetName();
        this.province = address.getProvince();
        this.locality = address.getLocality();
    }
}
