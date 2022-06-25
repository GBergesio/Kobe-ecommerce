package challenge.ecommerce.dtos;

import challenge.ecommerce.enums.Category;
import challenge.ecommerce.models.Product;
import lombok.Data;

@Data
public class ProductDto {
    private Long id;
    private Category category;
    private String tag;
    private String name;
    private String img;
    private String description;
    private Double price;
    private Integer stock;
    private Byte discount;

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
        this.discount = product.getDiscount();
    }
}
