package challenge.ecommerce.repositories;

import challenge.ecommerce.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.transaction.annotation.Transactional;

@RepositoryRestResource
public interface ClientRepository extends JpaRepository<Client, Long> {
    Client findByEmail(String  email);

    @Transactional
    @Modifying
    @Query("UPDATE Client c " +
    "SET c.active = TRUE WHERE c.email = ?1")
    int enableClient(String email);
}
