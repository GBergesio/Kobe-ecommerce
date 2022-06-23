package challenge.ecommerce.repositories;

import challenge.ecommerce.models.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PurcharseRepository extends JpaRepository<Purchase, Long> {
}
