package challenge.ecommerce.dtos;

import challenge.ecommerce.models.Address;
import lombok.Getter;

@Getter
public class AddPersonalInformationDto {

    private long id;

    private long zipCode;

    private long streetNumber;

    private long dni;

    private String floorApartment;

    private String streetName;

    private String province;

    private String locality;

    public AddPersonalInformationDto(){}

    public AddPersonalInformationDto(Address address) {
        this.zipCode = address.getZipCode();
        this.streetNumber = address.getStreetNumber();
        this.floorApartment = address.getFloorApartment();
        this.streetName = address.getStreetName();
        this.province = address.getProvince();
        this.locality = address.getLocality();
        this.dni = dni;
    }
}
