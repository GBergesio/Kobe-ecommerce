package challenge.ecommerce.repositories;

import challenge.ecommerce.models.PurchaseProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface PurchaseProductRepository extends JpaRepository<PurchaseProduct, Long>{

}