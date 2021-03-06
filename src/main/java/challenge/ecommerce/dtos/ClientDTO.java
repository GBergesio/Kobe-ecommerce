package challenge.ecommerce.dtos;

import challenge.ecommerce.models.Client;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Data
public class ClientDTO {

    private long id;

    private boolean active;

    private String name;
    private String lastName;
    private String email;
    private  String password;

    private Long dni;

    private Set<PurchaseDto> purchases = new HashSet<>();

//    private Set<Post> post = new HashSet<>();

    private Set<AddressDTO> addresses = new HashSet<>();

    public ClientDTO(){}
    public ClientDTO(Client client){
        this.id = client.getId();
        this.name = client.getName();
        this.lastName = client.getLastName();
        this.email = client.getEmail();
        this.password = client.getPassword();
        this.dni = client.getDni();
        this.active = client.isActive();
        this.purchases = client.getPurchases().stream().map(PurchaseDto::new).collect(Collectors.toSet());
        this.addresses = client.getAddresses().stream().map(AddressDTO::new).collect(Collectors.toSet());
//        this.post = client.getPost();
    }
}
