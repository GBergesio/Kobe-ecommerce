package challenge.ecommerce.dtos;

import challenge.ecommerce.enums.Category;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ProductApplicationDto {
    private String name;
    private String description;
    private String img;
    private String imgSec;
    private Short stock;
    private Double price;
    private String serie;
    private Category category;
    private String subcategory;

    public ProductApplicationDto(){}
    public ProductApplicationDto(String name, String description, String img, String imgSec, Short stock, Double price,
                                 String serie, Category category, String subcategory){
        this.name = name;
        this.description = description;
        this.img = img;
        this.imgSec = imgSec;
        this.stock = stock;
        this.price = price;
        this.serie = serie;
        this.category = category;
        this.subcategory = subcategory;
    }

    public boolean isSomePropertyNull(){
        return this.img == null || this.imgSec == null || this.description == null || this.name == null || this.subcategory == null
                || this.price == null || this.stock == null || this.category == null || this.serie == null;
    }
}
