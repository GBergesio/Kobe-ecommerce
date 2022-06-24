package challenge.ecommerce.dtos;

import challenge.ecommerce.enums.Category;
import challenge.ecommerce.models.Product;
import lombok.Data;

@Data
public class ProductDto {
    private long id;
    private String img;
    private String description;
    private String name;
    private String tag;
    private double price;
    private long stock;
    private Category category;

    public ProductDto(){}
    public ProductDto(Product product){
        this.id = product.getId();
        this.img = product.getImg();
        this.description = product.getDescription();
        this.name = product.getName();
        this.tag = product.getTag();
        this.price = product.getPrice();
        this.stock = product.getStock();
        this.category = product.getCategory();
    }
}
