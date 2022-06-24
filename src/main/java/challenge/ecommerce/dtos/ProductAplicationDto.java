package challenge.ecommerce.dtos;

import challenge.ecommerce.enums.Category;
import lombok.Data;

@Data
public class ProductAplicationDto {
    private String img;
    private String description;
    private String name;
    private String tag;
    private Double price;
    private Long stock;
    private String category;

    public ProductAplicationDto(){}

    public boolean isSomePropertyNull(){
        if(this.img == null || this.description == null || this.name == null || this.tag == null
        ||this.price == null || this.stock == null || this.category == null){
            return true;
        }
        return false;
    }
}
