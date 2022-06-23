package challenge.ecommerce.repositories;

import challenge.ecommerce.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientsRepository extends JpaRepository<Client, Long> {
}
