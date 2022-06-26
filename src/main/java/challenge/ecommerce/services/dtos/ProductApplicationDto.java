package challenge.ecommerce.services.dtos;

import challenge.ecommerce.enums.Category;
import lombok.Data;

@Data
public class ProductApplicationDto {
    private String name;
    private String description;
    private String img;
    private Short stock;
    private Double price;
    private String serie;
    private String category;
    private String subcategory;

    public ProductApplicationDto(){}

    public boolean isSomePropertyNull(){
        if(this.img == null || this.description == null || this.name == null || this.subcategory == null
        ||this.price == null || this.stock == null || this.category == null || this.serie == null){
            return true;
        }
        return false;
    }
}
