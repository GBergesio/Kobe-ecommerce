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
    private String name, lastName, password;
    @Column(unique = true)
    private String email;
    private UserType userType;

    private long dni;

    @OneToMany(mappedBy = "client", fetch=FetchType.EAGER)
    private Set<Purchase> purchase = new HashSet<>();

    @OneToMany(mappedBy = "client", fetch=FetchType.EAGER)
    private Set<Post> post = new HashSet<>();

    @OneToMany(mappedBy = "client", fetch=FetchType.EAGER)
    private Set<Adress> address = new HashSet<>();

    @OneToMany(mappedBy = "user")
    private Set<SecureToken> tokens = new HashSet<>();

    public Client(){};

    public Client(String name, String lastName, String email, String password) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.userType = UserType.USER;
    }
}
