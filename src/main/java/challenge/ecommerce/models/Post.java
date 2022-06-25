package challenge.ecommerce.models;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.security.PublicKey;
import java.time.LocalDateTime;

@Entity
@Data
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private long id;

    private String text, title;

    private LocalDateTime postDate;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="client_id")
    private Client client;

    public Post(){}
    public Post(String text, String title, LocalDateTime postDate) {
        this.text = text;
        this.title = title;
        this.postDate = postDate;
    }
}
