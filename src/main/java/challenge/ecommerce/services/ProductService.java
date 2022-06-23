package challenge.ecommerce.services;

import challenge.ecommerce.enums.Category;
import challenge.ecommerce.models.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAll();
    List<Product> getByCategory(Category category);
}
