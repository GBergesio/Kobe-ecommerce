package challenge.ecommerce.controllers;

import challenge.ecommerce.dtos.NewAddressDTO;
import challenge.ecommerce.models.Address;
import challenge.ecommerce.models.Client;
import challenge.ecommerce.services.AddressService;
import challenge.ecommerce.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

@RestController
@RequestMapping("/api")
public class AddressController {

    @Autowired
    AddressService addressService;

    @Autowired
    ClientService clientService;

    @GetMapping("/addresses")
    ResponseEntity<?> getAddresses(){
        return new ResponseEntity<>(addressService.getAddresses(), HttpStatus.OK);
    }

    @Transactional
    @PostMapping("/newAddress")
    ResponseEntity<Object> newAddress(@RequestBody NewAddressDTO newAddressDTO, Authentication authentication){

        if(authentication == null){
            return new ResponseEntity<>("Debes estar logueado para agregar una nueva direccion", HttpStatus.FORBIDDEN);
        }

        Client currentClient = clientService.getCurrentClient(authentication);

        Pattern patOnlyLetters = Pattern.compile("^[a-zA-Z\\s+]{1,}");

        Pattern lettersAndNumbers = Pattern.compile("[\\da-zA-Z\\s+]{0,6}");

        Matcher FloorApartment = lettersAndNumbers.matcher(newAddressDTO.getFloorApartment());
        Matcher locality = patOnlyLetters.matcher(newAddressDTO.getLocality());
        Matcher streetName = patOnlyLetters.matcher(newAddressDTO.getStreetName());
        Matcher province = patOnlyLetters.matcher(newAddressDTO.getProvince());

        if(!FloorApartment.matches()){
            return new ResponseEntity<>("This ir not a valid floor apartment", HttpStatus.FORBIDDEN);
        }

        if(newAddressDTO.getLocality().isEmpty()){
            return new ResponseEntity<>("Locality is empty", HttpStatus.FORBIDDEN);
        }

        if(!locality.matches()){
            return new ResponseEntity<>("The locality can't contain numbers or symbols", HttpStatus.FORBIDDEN);
        }

        if(newAddressDTO.getProvince().isEmpty()){
            return new ResponseEntity<>("Province is empty", HttpStatus.FORBIDDEN);
        }

        if(!province.matches()){
            return new ResponseEntity<>("The province can't contain numbers or symbols", HttpStatus.FORBIDDEN);
        }

        if(newAddressDTO.getStreetName().isEmpty()){
            return new ResponseEntity<>("Street name is empty", HttpStatus.FORBIDDEN);
        }

        if(!streetName.matches()){
            return new ResponseEntity<>("The street name can't contain numbers or symbols", HttpStatus.FORBIDDEN);
        }

        if(newAddressDTO.getStreetNumber() <= 0){
            return new ResponseEntity<>("Not a valid street number", HttpStatus.FORBIDDEN);
        }

        if(newAddressDTO.getZipCode() <= 0){
            return new ResponseEntity<>("Not a valid Zip number", HttpStatus.FORBIDDEN);
        }

        Address address = new Address(newAddressDTO.getZipCode(), newAddressDTO.getStreetNumber(), newAddressDTO.getFloorApartment(), newAddressDTO.getStreetName(), newAddressDTO.getProvince(), newAddressDTO.getLocality());
        addressService.saveAddress(address);

        currentClient.addAddress(address);
        clientService.saveClient(currentClient);

        return new ResponseEntity<>("Address added successfully", HttpStatus.CREATED);

    }
}
