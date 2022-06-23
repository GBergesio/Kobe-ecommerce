package challenge.ecommerce.controllers;

import challenge.ecommerce.dtos.ClientDTO;
import challenge.ecommerce.dtos.RegisterDTO;
import challenge.ecommerce.models.Client;
import challenge.ecommerce.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.regex.Pattern;
import java.util.regex.Matcher;


@RestController
@RequestMapping("/api")
public class ClientController {

    @Autowired
    ClientService clientService;

    @GetMapping("/clients")
    ResponseEntity<?> getClients(){
     return new ResponseEntity<>(clientService.getClientsDTO(), HttpStatus.OK);
    }

    @GetMapping("/clients/{id}")
    ResponseEntity <?> getClientDTO(@PathVariable Long id){
        return new ResponseEntity<>(clientService.getClientDTO(id), HttpStatus.OK);
    }

    @PostMapping("/clientRegister")
    public ResponseEntity<Object> register(@RequestBody RegisterDTO registerDTO){

        Pattern patPassword = Pattern.compile("[a­zA­Z]{5,10}");

        Pattern patEmail = Pattern.compile("^[\\w­]+(\\.[\\w­]+)*@[A­Za­z0­9]+(\\.[A­Za­z0­9]+)*(\\.[A­Za­z]{2,})$");

        Pattern patOnlyLetters = Pattern.compile("[a­zA­Z]");

        Matcher email = patEmail.matcher(registerDTO.getEmail());
        Matcher name = patOnlyLetters.matcher(registerDTO.getName());
        Matcher lastName = patOnlyLetters.matcher(registerDTO.getLastName());
        Matcher password = patPassword.matcher(registerDTO.getPassword());


        if(registerDTO.getEmail().isEmpty()){
            return new ResponseEntity<>("Email is empty", HttpStatus.FORBIDDEN);
        }

        if(!email.matches()){
            return new ResponseEntity<>("Not a valid email", HttpStatus.FORBIDDEN);
        }

        if(registerDTO.getPassword().isEmpty()){
            return new ResponseEntity<>("Password is empty", HttpStatus.FORBIDDEN);
        }

        if(!password.matches()){
            return new ResponseEntity<>("Not a valid password", HttpStatus.FORBIDDEN);
        }

        if(registerDTO.getName().isEmpty()){
            return new ResponseEntity<>("Name is empty", HttpStatus.FORBIDDEN);
        }

        if(!name.matches()){
            return new ResponseEntity<>("The name can't contain numbers or symbols", HttpStatus.FORBIDDEN);
        }

        if(registerDTO.getLastName().isEmpty()){
            return new ResponseEntity<>("Last name is empty", HttpStatus.FORBIDDEN);
        }

        if(!lastName.matches()){
            return new ResponseEntity<>("The last name can't contain numbers or symbols", HttpStatus.FORBIDDEN);
        }

        if(clientService.findByEmail(registerDTO.getEmail()) != null){
            return new ResponseEntity<>("Email is already in use", HttpStatus.FORBIDDEN);
        }

        Client client = new Client(registerDTO.getName(), registerDTO.getLastName(), registerDTO.getEmail(), registerDTO.getPassword());
        clientService.saveClient(client);

        return new ResponseEntity<>("Registered successfully, please activate your email to use your account", HttpStatus.CREATED);
    }

}
