package challenge.ecommerce.dtos;

import lombok.Data;
import lombok.Getter;
import org.springframework.web.bind.annotation.GetMapping;

@Data
public class RegisterDTO {

    private String firstName;
    private String lastName;
    private String email;
    private String password;

    public RegisterDTO(){}
    public RegisterDTO(String email, String lastName, String password, String firstName){
        this.email = email;
        this.lastName = lastName;
        this.firstName = firstName;
        this.password = password;
    }
}
