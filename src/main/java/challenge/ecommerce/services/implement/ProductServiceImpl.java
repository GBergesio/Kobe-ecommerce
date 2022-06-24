package challenge.ecommerce.services.implement;

import challenge.ecommerce.dtos.ProductApplicationDto;
import challenge.ecommerce.enums.Category;
import challenge.ecommerce.models.Product;
import challenge.ecommerce.repositories.ProductRepository;
import challenge.ecommerce.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> getAll() {
        return productRepository.findAll().stream().filter(product -> !product.isDeleted()).collect(Collectors.toList());
    }

    @Override
    public List<Product> getByCategory(Category category) {
        return productRepository.findByCategory(category).stream().filter(product -> !product.isDeleted()).collect(Collectors.toList());
    }

    @Override
    public void create(ProductApplicationDto productApplicationDto) {
        productRepository.save(new Product(productApplicationDto.getImg(), productApplicationDto.getDescription(),
                productApplicationDto.getName(), productApplicationDto.getPrice(), productApplicationDto.getStock(),
                Category.valueOf(productApplicationDto.getCategory()), productApplicationDto.getTag()));
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
