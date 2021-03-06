package challenge.ecommerce.repositories;

import challenge.ecommerce.enums.Category;
import challenge.ecommerce.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByCategory(Category category);
    List<Product> findBySubcategory(String subcategory);
    List<Product> findBySerie(String serie);

    boolean existsBySubcategory(String subcategory);
    boolean existsBySerie(String serie);

}
