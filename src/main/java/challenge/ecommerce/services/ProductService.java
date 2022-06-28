package challenge.ecommerce.services;

import challenge.ecommerce.dtos.ProductApplicationDto;
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

    void updatePrice(Product product, Double price);

    void updateDescription(Product product, String description);

    void updateImg(Product product, String img);
    void updateImgSec(Product product, String imgSec);

    void updateStock(Product product, Short stock);

    void updateAll(Short percentage, String modifier);
}
