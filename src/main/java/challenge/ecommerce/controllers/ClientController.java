package challenge.ecommerce.controllers;

import challenge.ecommerce.dtos.AddPersonalInformationDto;
import challenge.ecommerce.dtos.ClientDTO;
import challenge.ecommerce.dtos.RegisterDTO;
import challenge.ecommerce.models.Address;
import challenge.ecommerce.models.Client;
import challenge.ecommerce.services.AddressService;
import challenge.ecommerce.models.RegistrationRequest;
import challenge.ecommerce.services.ClientService;
import challenge.ecommerce.services.implement.ClientServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


@RestController
@RequestMapping("/api")
public class ClientController {

    @Autowired
    ClientService clientService;

    @Autowired
    AddressService addressService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    ClientServiceImpl clientServiceImpl;

    private RegistrationRequest registrationRequest = new RegistrationRequest();


    @GetMapping("/clients")
    ResponseEntity<?> getClients(){
     return new ResponseEntity<>(clientService.getClientsDTO(), HttpStatus.OK);
    }


    @GetMapping("/clients/{id}")
    ResponseEntity <?> getClientDTO(@PathVariable Long id){
        return new ResponseEntity<>(clientService.getClientDTO(id), HttpStatus.OK);
    }

    @GetMapping("/clients/current")
    public ResponseEntity<?> getCurrentClient(Authentication authentication){
        return(new ResponseEntity<>(new ClientDTO(clientService.getCurrentClient(authentication)),HttpStatus.ACCEPTED));
    }

    @Transactional
    @PostMapping("/clients")
    public ResponseEntity<Object> register(@RequestBody RegisterDTO registerDTO){

        Pattern patPassword = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{8,}$");

        Pattern patEmail = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"+"[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");

        Pattern patOnlyLetters = Pattern.compile("^[a-zA-Z]{1,}");

        Matcher email = patEmail.matcher(registerDTO.getEmail());
        Matcher name = patOnlyLetters.matcher(registerDTO.getFirstName());
        Matcher lastName = patOnlyLetters.matcher(registerDTO.getLastName());
        Matcher password = patPassword.matcher(registerDTO.getPassword());


        if(registerDTO.getEmail().isEmpty()){
            return new ResponseEntity<>("Email vacio", HttpStatus.FORBIDDEN);
        }

        if(!email.matches()){
            return new ResponseEntity<>("Email invalido", HttpStatus.FORBIDDEN);
        }

        if(registerDTO.getPassword().isEmpty()){
            return new ResponseEntity<>("Password inválido, Se requiere al menos 8 caracteres, una mayúscula y un numero", HttpStatus.FORBIDDEN);
        }

        if(!password.matches()){
            return new ResponseEntity<>("Password inválido", HttpStatus.FORBIDDEN);
        }

        if(registerDTO.getFirstName().isEmpty()){
            return new ResponseEntity<>("Nombre vacio", HttpStatus.FORBIDDEN);
        }

        if(!name.matches()){
            return new ResponseEntity<>("Nombre no puede contener simbolos ni numeros", HttpStatus.FORBIDDEN);
        }

        if(registerDTO.getLastName().isEmpty()){
            return new ResponseEntity<>("Apellido vacio", HttpStatus.FORBIDDEN);
        }

        if(!lastName.matches()){
            return new ResponseEntity<>("Apellido no puede contener simbolos ni numeros", HttpStatus.FORBIDDEN);
        }

        if(clientService.findByEmail(registerDTO.getEmail()) != null){
            return new ResponseEntity<>("Email en uso, prueba otro", HttpStatus.FORBIDDEN);
        }

        registrationRequest.setName(registerDTO.getFirstName());
        registrationRequest.setLastName(registerDTO.getLastName());
        registrationRequest.setEmail(registerDTO.getEmail());
        registrationRequest.setPassword(registerDTO.getPassword());

        if(clientServiceImpl.createClient(registrationRequest)){
            return new ResponseEntity<>("Cliente registardo, revisa tu email", HttpStatus.ACCEPTED);
        }

        return new ResponseEntity<>("Registro exitoso, activa tu cuenta desde tu correo electrónico", HttpStatus.CREATED);
    }

    @Transactional
    @PostMapping("/clientAddData")
    public ResponseEntity<Object> addDataClient(@RequestBody AddPersonalInformationDto addPersonalInformationDto, Authentication authentication){

        Client currentClient = clientService.getCurrentClient(authentication);

        Pattern patOnlyLetters = Pattern.compile("^[a-zA-Z\\s+]{1,}");

        Pattern lettersAndNumbers = Pattern.compile("[\\da-zA-Z\\s+]{1,6}");


        Matcher FloorApartment = lettersAndNumbers.matcher(addPersonalInformationDto.getFloorApartment());
        Matcher locality = patOnlyLetters.matcher(addPersonalInformationDto.getLocality());
        Matcher streetName = patOnlyLetters.matcher(addPersonalInformationDto.getStreetName());
        Matcher province = patOnlyLetters.matcher(addPersonalInformationDto.getProvince());


        if(addPersonalInformationDto.getDni() == 0 || addPersonalInformationDto.getDni() < 0){
            return new ResponseEntity<>("The DNI number is not valid", HttpStatus.FORBIDDEN);
        }

        if(addPersonalInformationDto.getFloorApartment().isEmpty()){
            return new ResponseEntity<>("Floor Apartment is empty", HttpStatus.FORBIDDEN);
        }

        if(!FloorApartment.matches()){
            return new ResponseEntity<>("This ir not a valid floor apartment", HttpStatus.FORBIDDEN);
        }

        if(addPersonalInformationDto.getLocality().isEmpty()){
            return new ResponseEntity<>("Locality is empty", HttpStatus.FORBIDDEN);
        }

        if(!locality.matches()){
            return new ResponseEntity<>("The locality can't contain numbers or symbols", HttpStatus.FORBIDDEN);
        }

        if(addPersonalInformationDto.getProvince().isEmpty()){
            return new ResponseEntity<>("Province is empty", HttpStatus.FORBIDDEN);
        }

        if(!province.matches()){
            return new ResponseEntity<>("The province can't contain numbers or symbols", HttpStatus.FORBIDDEN);
        }

        if(addPersonalInformationDto.getStreetName().isEmpty()){
            return new ResponseEntity<>("Street name is empty", HttpStatus.FORBIDDEN);
        }

        if(!streetName.matches()){
            return new ResponseEntity<>("The street name can't contain numbers or symbols", HttpStatus.FORBIDDEN);
        }

        if(addPersonalInformationDto.getStreetNumber() <= 0){
            return new ResponseEntity<>("Not a valid street number", HttpStatus.FORBIDDEN);
        }

        if(addPersonalInformationDto.getZipCode() <= 0){
            return new ResponseEntity<>("Not a valid Zip number", HttpStatus.FORBIDDEN);
        }


        Address address = new Address(addPersonalInformationDto.getZipCode(), addPersonalInformationDto.getStreetNumber(), addPersonalInformationDto.getFloorApartment(), addPersonalInformationDto.getStreetName(), addPersonalInformationDto.getProvince(), addPersonalInformationDto.getLocality());
        addressService.saveAddress(address);
        currentClient.addAddress(address);

        currentClient.setDni(addPersonalInformationDto.getDni());
        clientService.saveClient(currentClient);

        return new ResponseEntity<>("Data added successfully!", HttpStatus.CREATED);
    }

    @Transactional
    @PatchMapping("/clientAddData")
    public ResponseEntity<Object> editDataClient
            (Authentication authentication, @RequestParam String streetName,
             @RequestParam String floorApartment, @RequestParam String province,
             @RequestParam String locality, @RequestParam long zipCode,
             @RequestParam long streetNumber,
             @RequestParam long id, @RequestParam String dni,
             @RequestParam String name,
             @RequestParam String lastName, @RequestParam String password
            ){

        Client currentClient = clientService.getCurrentClient(authentication);
        Address currentAddress = addressService.findById(id);

        Pattern patOnlyLetters = Pattern.compile("^[a-zA-Z\\s+]{1,}");
        Pattern patNumbers = Pattern.compile("^[\\d-\\+]{6,8}");
        Pattern lettersAndNumbers = Pattern.compile("[\\da-zA-Z\\s+]{1,6}");


        Matcher patFloorApartment = lettersAndNumbers.matcher(floorApartment);
        Matcher patLocality = patOnlyLetters.matcher(locality);
        Matcher patStreetName = patOnlyLetters.matcher(streetName);
        Matcher patProvince = patOnlyLetters.matcher(province);
        Matcher patDni = patNumbers.matcher(dni);
        Matcher patName = patOnlyLetters.matcher(name);
        Matcher patLastName = patOnlyLetters.matcher(lastName);

        if(!passwordEncoder.matches(password, currentClient.getPassword())){
            return new ResponseEntity<>("Please enter the right password", HttpStatus.FORBIDDEN);
        }

        if(!name.isEmpty() && !patName.matches()){
            return new ResponseEntity<>("The name is not valid", HttpStatus.FORBIDDEN);
        }

        if(!name.isEmpty() && patName.matches()){
            currentClient.setName(name);
        }

        if(!lastName.isEmpty() && !patLastName.matches()){
            return new ResponseEntity<>("The last name is not valid", HttpStatus.FORBIDDEN);
        }

        if(!lastName.isEmpty() && patLastName.matches()){
            currentClient.setLastName(lastName);
        }

        if(!dni.isEmpty() && !patDni.matches()){
            return new ResponseEntity<>("The DNI is not valid", HttpStatus.FORBIDDEN);
        }

        if(!dni.isEmpty() && patDni.matches()){
            long dniNum = Long.parseLong(dni);
            currentClient.setDni(dniNum);
            clientService.saveClient(currentClient);
        }

        if(zipCode < 0){
            return new ResponseEntity<>("The Zip Code number is not valid", HttpStatus.FORBIDDEN);
        }

        if(zipCode != 0 && zipCode > 0){
            currentAddress.setZipCode(zipCode);
            addressService.saveAddress(currentAddress);
        }

        if(streetNumber < 0){
            return new ResponseEntity<>("This is not a valid street number", HttpStatus.FORBIDDEN);
        }

        if(streetNumber != 0 && streetNumber > 0){
            currentAddress.setStreetNumber(streetNumber);
        }

        if(!floorApartment.isEmpty()  && !patFloorApartment.matches()){
            return new ResponseEntity<>("The floor apartment is not valid", HttpStatus.FORBIDDEN);
        }

        if(!floorApartment.isEmpty() && patFloorApartment.matches()){
            currentAddress.setFloorApartment(floorApartment);
        }

        if(!province.isEmpty() && !patProvince.matches()){
            return new ResponseEntity<>("The province is not valid", HttpStatus.FORBIDDEN);
        }

        if(!province.isEmpty() && patProvince.matches()){
            currentAddress.setProvince(province);
        }

        if(!locality.isEmpty() && !patLocality.matches()){
            return new ResponseEntity<>("The locality is not valid", HttpStatus.FORBIDDEN);
        }

        if(!locality.isEmpty() && patLocality.matches()){
            currentAddress.setLocality(locality);
        }

        if(!streetName.isEmpty() && !patStreetName.matches()){
            return new ResponseEntity<>("The street name is not valid", HttpStatus.FORBIDDEN);
        }

        if(!streetName.isEmpty() && patStreetName.matches()){
            currentAddress.setStreetName(streetName);
        }

        clientService.saveClient(currentClient);
        addressService.saveAddress(currentAddress);

        return new ResponseEntity<>("Data edited successfully!", HttpStatus.CREATED);
    }

    @Transactional
    @PatchMapping("/deleteClient")
    ResponseEntity<Object> deleteClient(Authentication authentication, @RequestParam String password){

        Client currentClient = clientService.getCurrentClient(authentication);

        if(!passwordEncoder.matches(password, currentClient.getPassword())){
            return new ResponseEntity<>("Please enter the right password", HttpStatus.FORBIDDEN);
        }

        currentClient.setActive(false);
        clientService.saveClient(currentClient);

        return new ResponseEntity<>("Client deleted successfully!", HttpStatus.CREATED);
    }


//hacer produtos BOOKSHOP
//borrar direcciones
    @GetMapping("/clients/confirm")
    public ResponseEntity<Object> confirmEmail(@RequestParam("token") String token, HttpServletResponse resp) throws IOException {
        String response = clientServiceImpl.confirmClientEmail(token);

        if (response.equalsIgnoreCase("confirmed")) {
            resp.setStatus(200);
            resp.sendRedirect("/store/index.html");
            return new ResponseEntity<>(response,HttpStatus.ACCEPTED);
        }

        return new ResponseEntity<>(response, HttpStatus.FORBIDDEN);
    }

}
