package challenge.ecommerce.models;

import challenge.ecommerce.enums.Category;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private Long id;

    private String img;
    private String description;
    private String name;
    private String tag;
    private Double price;
    private Integer stock;
    private Category category;
    private Byte discount;
    private boolean deleted;

    public Product(){}
    public Product(String img, String description, String name, Double price, Integer stock, Category category, String tag) {
        this.img = img;
        this.description = description;
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.category = category;
        this.tag = tag;
        this.discount = 0;
        this.deleted = false;
    }

}
