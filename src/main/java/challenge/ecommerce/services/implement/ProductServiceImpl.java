package challenge.ecommerce.services.implement;

import challenge.ecommerce.dtos.ProductAplicationDto;
import challenge.ecommerce.enums.Category;
import challenge.ecommerce.models.Product;
import challenge.ecommerce.repositories.ProductRepository;
import challenge.ecommerce.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    @Override
    public List<Product> getByCategory(Category category) {
        return productRepository.findByCategory(category);
    }

    @Override
    public void create(ProductAplicationDto productAplicationDto) {
        productRepository.save(new Product(productAplicationDto.getImg(), productAplicationDto.getDescription(),
                productAplicationDto.getName(), productAplicationDto.getPrice(), productAplicationDto.getStock(),
                Category.valueOf(productAplicationDto.getCategory()), productAplicationDto.getTag()));
    }

    @Override
    public Product getById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(Product product) {
        product.setDeleted(true);
        this.save(product);
    }

    @Override
    public void save(Product product) {
        productRepository.save(product);
    }

//    @Override
//    public boolean existProperty(String propertyName) {
//        String lowerCaseProperty = propertyName.toLowerCase();
////        private Category category;
//        boolean exist = false;
//        switch (lowerCaseProperty){
//            case "img":
//                exist = true;
//                break;
//            case "description":
//                exist = true;
//                break;
//            case "name":
//                exist = true;
//                break;
//            case "tag":
//                exist = true;
//                break;
//            case "price":
//                exist = true;
//                break;
//            case "":
//                exist = true;
//                break;
//
//        }
//        return false;
//    }
}
