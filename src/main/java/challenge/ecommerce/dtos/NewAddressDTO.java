package challenge.ecommerce.dtos;

import lombok.Getter;

@Getter
public class NewAddressDTO {
    private long zipCode, streetNumber;
    private String floorApartment, streetName, province, locality;

    public NewAddressDTO(){}
    public NewAddressDTO(long zipCode, long streetNumber, String floorApartment, String streetName, String province, String locality) {
        this.zipCode = zipCode;
        this.streetNumber = streetNumber;
        this.floorApartment = floorApartment;
        this.streetName = streetName;
        this.province = province;
        this.locality = locality;
    }
}
