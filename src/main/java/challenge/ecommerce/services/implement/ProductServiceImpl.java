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
                productApplicationDto.getName(), productApplicationDto.getStock(), productApplicationDto.getPrice(),
                productApplicationDto.getSubcategory(), Category.valueOf(productApplicationDto.getCategory()), productApplicationDto.getSerie()));
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

    @Override
    public void updatePrice(Product product, Double price) {
        product.setPrice(price);
    }

    @Override
    public void updateDescription(Product product, String description) {
        product.setDescription(description);
    }

    @Override
    public void updateImg(Product product, String img) {
        product.setImg(img);
    }

    @Override
    public void updateStock(Product product, Short stock) {
        product.setStock(stock);
    }

    @Override
    public void updateAll(Short percentage, String modifier) {
        if(modifier.equals("INCREASE")){
            Float increasePercentage =  1 + (Float.valueOf(percentage)/100);
            this.setPrices(increasePercentage);
        }else{
            Float increasePercentage =  1 - (Float.valueOf(percentage)/100);
            this.setPrices(increasePercentage);
        }
    }
    private void setPrices(Float modifier){
        productRepository.findAll().forEach(product -> {
            product.setPrice(product.getPrice() * modifier);
            productRepository.save(product);
        });
    }
}
