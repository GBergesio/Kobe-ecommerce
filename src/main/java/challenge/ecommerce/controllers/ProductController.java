package challenge.ecommerce.controllers;

import challenge.ecommerce.dtos.ProductApplicationDto;
import challenge.ecommerce.dtos.ProductDto;
import challenge.ecommerce.enums.Category;
import challenge.ecommerce.models.Product;
import challenge.ecommerce.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping ("/products")
    public ResponseEntity<?> getProducts() {
        return new ResponseEntity<>(productService.getAll().stream().filter(product1 -> product1.getStock() > 0).map(ProductDto::new).collect(Collectors.toList()),
                HttpStatus.OK);
    }

    @GetMapping("/products/category")
    public ResponseEntity<?> getByCategory(@RequestParam Category category){
        return new ResponseEntity<>(productService.getByCategory(category).stream().map(ProductDto::new).collect(Collectors.toList()),
                HttpStatus.OK);
    }
    @PostMapping("/products")
    public ResponseEntity<?> add(@RequestBody ProductApplicationDto productApplicationDto){
        if(productApplicationDto.isSomePropertyNull()){
            return new ResponseEntity<>("Missing data", HttpStatus.FORBIDDEN);
        }
        if(productApplicationDto.getPrice() <= 0){
            return new ResponseEntity<>("the price cannot be negative",HttpStatus.FORBIDDEN);
        }
        //validar q se pueda construir un enum Category a partir del string provisto en productAplicationDto

        productService.create(productApplicationDto);
        return new ResponseEntity<>("Product added successfully", HttpStatus.CREATED);
    }
    @PatchMapping ("/products")
    public ResponseEntity<?> delete(@RequestParam String id){

        if(id.isEmpty()){
            return new ResponseEntity<>("Missing data", HttpStatus.FORBIDDEN);
        }

        Long longId= Long.valueOf(id);
        Product product = productService.getById(longId);
        if(product == null){
            return new ResponseEntity<>("Product does not exist", HttpStatus.FORBIDDEN);
        }
        productService.delete(product);
        return new ResponseEntity<>("product has been deleted successfully", HttpStatus.OK);
    }

    //maniana vemos este!
//    @PatchMapping("/products/modify")
//    public ResponseEntity<?> modify(@RequestParam String property){
//        if(property.isEmpty()){
//            return new ResponseEntity<>("Missing data", HttpStatus.FORBIDDEN);
//        }
//
//    }
}
