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
        return productRepository.findAll().stream()
                .filter(product -> !product.isDeleted() && product.getStock() > 0)
                .collect(Collectors.toList());
    }

    @Override
    public List<Product> getByCategory(Category category) {
        return productRepository.findByCategory(category).stream().filter(product -> !product.isDeleted() && product.getStock() > 0)
                .collect(Collectors.toList());
    }

    @Override
    public void create(ProductApplicationDto productApplicationDto) {
        productRepository.save(new Product(productApplicationDto.getName(), productApplicationDto.getDescription(),
                productApplicationDto.getImg(), productApplicationDto.getImgSec(), productApplicationDto.getStock(), productApplicationDto.getPrice(),
                productApplicationDto.getSerie(), productApplicationDto.getCategory(), productApplicationDto.getSubcategory()));
    }

    @Override
    public Product getById(Long id) {
        Product product = productRepository.findById(id).orElse(null);
        if(product != null){
            return product.isDeleted() == false ? product : null;
        }
        return null;
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
    public void updateImgSec(Product product, String imgSec) {
        product.setImg(imgSec);
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

    @Override
    public List<Product> getBySubCategory(String subcategory) {
        return productRepository.findBySubcategory(subcategory).stream()
                .filter(product -> !product.isDeleted() && product.getStock() > 0).collect(Collectors.toList());
    }

    private void setPrices(Float modifier){
        productRepository.findAll().forEach(product -> {
            product.setPrice(product.getPrice() * modifier);
            productRepository.save(product);
        });
    }
}
