package challenge.ecommerce.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@Data
public class ConfirmationToken {
    @SequenceGenerator(
                        name = "token_seq",
                        sequenceName = "token_seq",
                        allocationSize = 1)
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "token_seq")
    private Long id;

    @Column(nullable = false)
    private String token;

    @Column(nullable = false)
    private LocalDateTime createAt;

    @Column(nullable = false)
    private LocalDateTime expiresAt;

    private LocalDateTime confirmedAt;

    @ManyToOne
    @JoinColumn(nullable = false, name = "client_id")
    private Client client;

    public ConfirmationToken(String token, LocalDateTime createAt, LocalDateTime expiresAt, Client client) {
        this.token = token;
        this.createAt = createAt;
        this.expiresAt = expiresAt;
        this.client = client;
    }
}
