package challenge.ecommerce.services.dtos;

import challenge.ecommerce.enums.Category;
import challenge.ecommerce.models.Product;
import lombok.Data;

@Data
public class ProductDto {
    private Long id;
    private String name;
    private String description;
    private String img;
    private Short stock;
    private Double price;
    private Byte discount;
    private String serie;
    private Category category;
    private String subcategory;
    private boolean deleted;

    public ProductDto(){}
    public ProductDto(Product product) {
        this.id = product.getId();
        this.name = product.getName();
        this.description = product.getDescription();
        this.img = product.getImg();
        this.stock = product.getStock();
        this.price = product.getPrice();
        this.discount = product.getDiscount();
        this.serie = product.getSerie();
        this.category = product.getCategory();
        this.subcategory = product.getSubcategory();
        this.deleted = product.isDeleted();
    }
}
