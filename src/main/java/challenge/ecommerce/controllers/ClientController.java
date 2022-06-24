package challenge.ecommerce.controllers;

import challenge.ecommerce.dtos.ClientDTO;
import challenge.ecommerce.dtos.RegisterDTO;
import challenge.ecommerce.enums.UserType;
import challenge.ecommerce.models.Client;
import challenge.ecommerce.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


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

    @Transactional
    @PostMapping("/clientRegister")
    public ResponseEntity<Object> register(@RequestBody RegisterDTO registerDTO){

        Pattern patPassword = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{8,}$");

        Pattern patEmail = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"+"[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");

        Pattern patOnlyLetters = Pattern.compile("^[a-zA-Z]{1,}");

        Matcher email = patEmail.matcher(registerDTO.getEmail());
        Matcher name = patOnlyLetters.matcher(registerDTO.getFirstName());
        Matcher lastName = patOnlyLetters.matcher(registerDTO.getLastName());
        Matcher password = patPassword.matcher(registerDTO.getPassword());


        if(registerDTO.getEmail().isEmpty()){
            return new ResponseEntity<>("Email is empty", HttpStatus.FORBIDDEN);
        }

        if(!email.matches()){
            return new ResponseEntity<>("Not a valid email", HttpStatus.FORBIDDEN);
        }

        if(registerDTO.getPassword().isEmpty()){
            return new ResponseEntity<>("Password must have at least 8 letters and require a number", HttpStatus.FORBIDDEN);
        }

        if(!password.matches()){
            return new ResponseEntity<>("Not a valid password", HttpStatus.FORBIDDEN);
        }

        if(registerDTO.getFirstName().isEmpty()){
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

        Client client = new Client(registerDTO.getFirstName(), registerDTO.getLastName(), registerDTO.getEmail(),
                clientService.encodePassword(registerDTO.getPassword()), UserType.CLIENT);
        clientService.saveClient(client);

        return new ResponseEntity<>("Registered successfully, please activate your email to use your account", HttpStatus.CREATED);
    }
    @GetMapping("/clients/current")
    public ResponseEntity<?> getCurrentClient(Authentication authentication){
        return(new ResponseEntity<>(new ClientDTO(clientService.getCurrentClient(authentication)),HttpStatus.ACCEPTED));
    }

}
