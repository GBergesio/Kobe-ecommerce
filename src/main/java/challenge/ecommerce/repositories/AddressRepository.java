package challenge.ecommerce.repositories;

import challenge.ecommerce.models.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
