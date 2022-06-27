package challenge.ecommerce.dtos;

import challenge.ecommerce.enums.Category;
import challenge.ecommerce.models.Product;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ProductDto {
    private Long id;
    private String name;
    private String description;
    private List<String> imgs = new ArrayList<>();
    private Short stock;
    private Double price;
    private Double lowStockPrice;
    private Double discount;
    private String serie;
    private Category category;
    private String subcategory;

    public ProductDto(){}
    public ProductDto(Product product) {
        this.id = product.getId();
        this.name = product.getName();
        this.description = product.getDescription();
        this.imgs = product.getImgs();
        this.stock = product.getStock();
        this.price = product.getPrice();
        this.lowStockPrice = product.getLowStockPrice();
        this.discount = product.getDiscount();
        this.serie = product.getSerie();
        this.category = product.getCategory();
        this.subcategory = product.getSubcategory();
    }
}
