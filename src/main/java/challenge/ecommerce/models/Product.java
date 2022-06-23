package challenge.ecommerce.models;

import challenge.ecommerce.enums.Category;
import challenge.ecommerce.enums.Size;
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
    private long id;

    private String img, description, name, tag;

    private double price;

    private long stock;

    private Category category;

    private Size size;

    @OneToMany(mappedBy = "product", fetch=FetchType.EAGER)
    private Set<Purchase> purchase = new HashSet<>();

    public Product(){};

    public Product(String img, String description, String name, double price, long stock, Category category, String tag) {
        this.img = img;
        this.description = description;
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.category = category;
        this.tag = tag;
    }

    public Product(String img, String description, String name, double price, long stock, Category category, Size size, Set<Purchase> purchase, String tag) {
        this.img = img;
        this.description = description;
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.category = category;
        this.size = size;
        this.purchase = purchase;
        this.tag = tag;
    }
}
