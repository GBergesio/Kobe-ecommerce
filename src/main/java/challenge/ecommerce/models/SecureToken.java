package challenge.ecommerce.models;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Entity
@Table(name = "secureTokens")
public class SecureToken {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String token;

    @CreationTimestamp
    @Column(updatable = false)
    private Timestamp timeStamp;

    @Column(updatable = false)
    @Basic(optional = false)
    private LocalDateTime expireAt;

    @ManyToOne
    @JoinColumn(name = "client_id", referencedColumnName = "id")
    private Client user;

    @Transient
    private boolean isExpired;

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the token
     */
    public String getToken() {
        return token;
    }

    /**
     * @param token the token to set
     */
    public void setToken(String token) {
        this.token = token;
    }

    /**
     * @return the timeStamp
     */
    public Timestamp getTimeStamp() {
        return timeStamp;
    }

    /**
     * @param timeStamp the timeStamp to set
     */
    public void setTimeStamp(Timestamp timeStamp) {
        this.timeStamp = timeStamp;
    }

    /**
     * @return the expireAt
     */
    public LocalDateTime getExpireAt() {
        return expireAt;
    }

    /**
     * @param expireAt the expireAt to set
     */
    public void setExpireAt(LocalDateTime expireAt) {
        this.expireAt = expireAt;
    }

    /**
     * @return the user
     */
    public Client getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(Client user) {
        this.user = user;
    }

    /**
     * @return the isExpired
     */
    public boolean isExpired() {
        return getExpireAt().isBefore(LocalDateTime.now()); // this is generic implementation, you can always make it
        // timezone specific
    }

    /**
     * @param isExpired the isExpired to set
     */
    public void setExpired(boolean isExpired) {
        this.isExpired = isExpired;
    }

    @Override
    public String toString() {
        return "SecureToken [id=" + id + ", token=" + token + ", timeStamp=" + timeStamp + ", expireAt=" + expireAt
                + ", user=" + user + ", isExpired=" + isExpired + "]";
    }

}

