package challenge.ecommerce.models;

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

    private String name, lastName, email, password;

    private long dni;

    @OneToMany(mappedBy = "client", fetch=FetchType.EAGER)
    private Set<Purchase> purchase = new HashSet<>();

    @OneToMany(mappedBy = "client", fetch=FetchType.EAGER)
    private Set<Post> post = new HashSet<>();

    @OneToMany(mappedBy = "client", fetch=FetchType.EAGER)
    private Set<Adress> adress = new HashSet<>();

    public Client(){};

    public Client(String name, String lastName, String email, String password) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }
}
