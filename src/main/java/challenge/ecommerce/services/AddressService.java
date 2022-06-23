package challenge.ecommerce.services;

import challenge.ecommerce.dtos.AddressDTO;
import challenge.ecommerce.models.Address;

import java.util.List;

public interface AddressService {
    List<AddressDTO> getAddresses();

    Address saveAddress(Address address);
}
