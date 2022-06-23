package challenge.ecommerce.dtos;

import lombok.Getter;
import org.springframework.web.bind.annotation.GetMapping;

@Getter
public class RegisterDTO {

    private String name, lastName, email, password;

    public RegisterDTO(String email, String lastName, String password, String name){
        this.email = email;
        this.lastName = lastName;
        this.name = name;
        this.password = password;
    }
}
