package challenge.ecommerce.services.implement;

import challenge.ecommerce.services.dtos.AddressDTO;
import challenge.ecommerce.models.Address;
import challenge.ecommerce.repositories.AddressRepository;
import challenge.ecommerce.services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    AddressRepository addressRepository;

    @Override
    public List<AddressDTO> getAddresses() {
        return addressRepository.findAll().stream().map(AddressDTO::new).collect(Collectors.toList());
    }

    @Override
    public Address saveAddress(Address address) {
        return addressRepository.save(address);
    }
}
