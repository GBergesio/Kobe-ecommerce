package challenge.ecommerce.repositories;

import challenge.ecommerce.models.SecureToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface SecureTokenRepository extends JpaRepository<SecureToken, Long> {

    SecureToken findByToken(final String token);
    Long removeByToken(String token);
}
