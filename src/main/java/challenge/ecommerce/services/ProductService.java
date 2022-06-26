package challenge.ecommerce.services;

import challenge.ecommerce.services.dtos.ProductApplicationDto;
import challenge.ecommerce.enums.Category;
import challenge.ecommerce.models.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAll();
    List<Product> getByCategory(Category category);

    void create(ProductApplicationDto productApplicationDto);

    Product getById(Long id);

    void delete(Product product);

    void save(Product product);

//    boolean existProperty(String propertyName);
}
