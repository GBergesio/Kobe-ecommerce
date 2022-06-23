package challenge.ecommerce.controllers;

import challenge.ecommerce.dtos.AddressDTO;
import challenge.ecommerce.models.Address;
import challenge.ecommerce.models.Client;
import challenge.ecommerce.services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

@RestController
@RequestMapping("/api")
public class AddressController {

    @Autowired
    AddressService addressService;

    @GetMapping("/addresses")
    ResponseEntity<?> getAddresses(){
        return new ResponseEntity<>(addressService.getAddresses(), HttpStatus.OK);
    }

    @Transactional
    @PostMapping("/newAddress")
    ResponseEntity<Object> newAddress(@RequestBody AddressDTO addressDTO){

        Pattern patNum = Pattern.compile("[\\d]");

        Pattern patOnlyLetters = Pattern.compile("[a­zA­Z]");

        Pattern lettersAndNumbers = Pattern.compile("[\\da-zA-Z]");

        Matcher FloorApartment = lettersAndNumbers.matcher(addressDTO.getFloorApartment());
        Matcher locality = patOnlyLetters.matcher(addressDTO.getLocality());
        Matcher streetName = patOnlyLetters.matcher(addressDTO.getStreetName());
        Matcher province = patOnlyLetters.matcher(addressDTO.getProvince());

        if(addressDTO.getFloorApartment().isEmpty()){
            return new ResponseEntity<>("Floor Apartment is empty", HttpStatus.FORBIDDEN);
        }

        if(!FloorApartment.matches()){
            return new ResponseEntity<>("Floor Apartment is empty", HttpStatus.FORBIDDEN);
        }

        if(addressDTO.getLocality().isEmpty()){
            return new ResponseEntity<>("Locality is empty", HttpStatus.FORBIDDEN);
        }

        if(!locality.matches()){
            return new ResponseEntity<>("The locality can't contain numbers or symbols", HttpStatus.FORBIDDEN);
        }

        if(addressDTO.getProvince().isEmpty()){
            return new ResponseEntity<>("Province is empty", HttpStatus.FORBIDDEN);
        }

        if(!province.matches()){
            return new ResponseEntity<>("The name can't contain numbers or symbols", HttpStatus.FORBIDDEN);
        }

        if(addressDTO.getStreetName().isEmpty()){
            return new ResponseEntity<>("Street name is empty", HttpStatus.FORBIDDEN);
        }

        if(!streetName.matches()){
            return new ResponseEntity<>("The street name can't contain numbers or symbols", HttpStatus.FORBIDDEN);
        }

        if(addressDTO.getStreetNumber() <= 0){
            return new ResponseEntity<>("Not a valid street number", HttpStatus.FORBIDDEN);
        }

        if(addressDTO.getZipCode() <= 0){
            return new ResponseEntity<>("Not a valid Zip number", HttpStatus.FORBIDDEN);
        }

        Address address = new Address(addressDTO.getZipCode(), addressDTO.getStreetNumber(), addressDTO.getFloorApartment(), addressDTO.getStreetName(), addressDTO.getProvince(), addressDTO.getLocality());
        addressService.saveAddress(address);

        return new ResponseEntity<>("Address added successfully", HttpStatus.CREATED);

    }
}
