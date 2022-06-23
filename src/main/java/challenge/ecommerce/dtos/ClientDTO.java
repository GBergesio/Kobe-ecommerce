package challenge.ecommerce.dtos;

import challenge.ecommerce.models.Address;
import challenge.ecommerce.models.Client;
import challenge.ecommerce.models.Post;
import challenge.ecommerce.models.Purchase;
import lombok.Getter;

import java.util.HashSet;
import java.util.Set;

@Getter
public class ClientDTO {

    private long id;

    private boolean active;

    private String name, lastName, email, password;

    private long dni;

    private Set<Purchase> purchase = new HashSet<>();

    private Set<Post> post = new HashSet<>();

    private Set<Address> addresses = new HashSet<>();

    public ClientDTO(Client client){
        this.id = client.getId();
        this.name = client.getName();
        this.lastName = client.getLastName();
        this.email = client.getEmail();
        this.password = client.getPassword();
        this.active = client.isActive();
//        this.purchase = client.getPurchase();
        this.addresses = client.getAddresses();
//        this.post = client.getPost();
    }
}
