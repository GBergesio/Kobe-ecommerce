package challenge.ecommerce.repositories;

import challenge.ecommerce.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


public interface ClientRepository extends JpaRepository<Client, Long> {
    Client findByEmail(String  email);
}
