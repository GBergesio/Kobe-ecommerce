package challenge.ecommerce.repositories;

import challenge.ecommerce.models.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


public interface PurchaseRepository extends JpaRepository<Purchase, Long> {
}
