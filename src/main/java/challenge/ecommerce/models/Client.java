package challenge.ecommerce.models;

import challenge.ecommerce.enums.UserType;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
@Getter
@Setter
public class Client {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private long id;

    private boolean active;
    private String name, lastName, email, password;

    private UserType userType;

    private long dni;

    @OneToMany(mappedBy = "client", fetch=FetchType.EAGER)
    private Set<Purchase> purchases = new HashSet<>();

    @OneToMany(mappedBy = "client", fetch=FetchType.EAGER)
    private Set<Post> posts = new HashSet<>();

    @OneToMany(mappedBy = "client", fetch=FetchType.EAGER)
    private Set<Address> addresses = new HashSet<>();

    public Client(){};

    public Client(String name, String lastName, String email, String password) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.userType = UserType.CLIENT;
    }
    public Client(String name, String lastName, String email, String password, UserType userType) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.active = false;
        this.userType = userType;
    }
    public void addAddress (Address address){
        address.setClient(this);
        addresses.add(address);
    }

    public void addPost (Post post){
        post.setClient(this);
        posts.add(post);
    }

    public void addPurchase (Purchase purchase){
        purchase.setClient(this);
        purchases.add(purchase);
    }



}
