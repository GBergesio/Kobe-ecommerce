package challenge.ecommerce.dtos;

import lombok.Data;

@Data
public class ProductApplicationDto {
    private String img;
    private String description;
    private String name;
    private String tag;
    private Double price;
    private Integer stock;
    private String category;

    public ProductApplicationDto(){}

    public boolean isSomePropertyNull(){
        if(this.img == null || this.description == null || this.name == null || this.tag == null
        ||this.price == null || this.stock == null || this.category == null){
            return true;
        }
        return false;
    }
}
