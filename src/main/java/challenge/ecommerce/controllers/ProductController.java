package challenge.ecommerce.controllers;

import challenge.ecommerce.dtos.ProductApplicationDto;
import challenge.ecommerce.dtos.ProductDto;
import challenge.ecommerce.enums.Category;
import challenge.ecommerce.models.Product;
import challenge.ecommerce.services.ProductService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping ("/products")
    public ResponseEntity<?> getProducts() {
        return new ResponseEntity<>(productService.getAll().stream().map(ProductDto::new).collect(Collectors.toList()),
                HttpStatus.OK);
    }

    @GetMapping("/products/{id}")
    public Product getProductDTO(@PathVariable Long id) {
        return productService.getById(id);
    };

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
    @PatchMapping ("/products/delete")
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

    @Transactional
    @PatchMapping("/products/modify")
    public ResponseEntity<?> modify(
            @RequestParam String productId,
            @RequestParam(required = false) Double price, @RequestParam(required = false) String img,
            @RequestParam(required = false) String imgSec, @RequestParam(required = false) String description,
            @RequestParam(required = false) Short stock
            ){

        if(productId.isEmpty()){
            return new ResponseEntity<>("Missing produtId",HttpStatus.FORBIDDEN);
        }

        Product product = productService.getById(Long.valueOf(productId));
        if(product == null){
            return new ResponseEntity<>("product does not exist", HttpStatus.FORBIDDEN);
        }

        if(price == null && img == null && imgSec == null && description == null && stock == null){
            return new ResponseEntity<>("No property was supplied to change", HttpStatus.FORBIDDEN);
        }

        if(price != null){
            if(price < 0){
                return new ResponseEntity<>("price can not be negative", HttpStatus.FORBIDDEN);
            }
            productService.updatePrice(product, price);
        }

        if(img != null && !img.isEmpty()){
            if(img.contains(" ")){
                return new ResponseEntity<>("url format invalid, url can not have white spaces", HttpStatus.FORBIDDEN);
            }
            productService.updateImg(product, img);
        }

        if(imgSec != null && !imgSec.isEmpty()){
            if(imgSec.contains(" ")){
                return new ResponseEntity<>("url format invalid, url can not have white spaces", HttpStatus.FORBIDDEN);
            }
            productService.updateImgSec(product, imgSec);
        }

        if(description != null && !description.isEmpty()){
            productService.updateDescription(product, description);
        }

        if(stock != null){
            if(stock < 0){
                return new ResponseEntity<>("stock can not be negative", HttpStatus.FORBIDDEN);
            }
            productService.updateStock(product, stock);
        }
        productService.save(product);
        return new ResponseEntity<>("Product updated successfully",HttpStatus.OK);

    }
    //recibe la palabra clave INCREASE, entonces aumenta el precio en ese porcentaje
    //si recibe la palabra clave DECREASE, entonces disminuye el precio en base al porcentaje suministrado
    @Transactional
    @PatchMapping("/products/updatePrices")
    public ResponseEntity<?> updateAll(@RequestParam Short percentage, @RequestParam String priceModifier){
        if(percentage < 0 || percentage > 100){
            return new ResponseEntity<>("The percentage must be between 0 and 100", HttpStatus.FORBIDDEN);
        }
        if(priceModifier.isEmpty()){
            return new ResponseEntity<>("Missing price modifier", HttpStatus.FORBIDDEN);
        }
        List<String> priceModifiers = Arrays.asList("INCREASE", "DECREASE");
        if(!priceModifiers.contains(priceModifier)){
            return new ResponseEntity<>("Price modifier invalid", HttpStatus.FORBIDDEN);
        }
        productService.updateAll(percentage, priceModifier);
        return new ResponseEntity<>("The price of the products was updated successfully", HttpStatus.OK);
    }
    @GetMapping("/products/subcategory")
    public ResponseEntity<?> getBySubCategory(@RequestParam String subcategory){
        if(subcategory.isEmpty()){
            return new ResponseEntity<>("No ingreso ninguna subcategoria", HttpStatus.FORBIDDEN);
        }
        if(!productService.existsBySubcategory(subcategory)){
            return new ResponseEntity<>("No existe ningun producto de la subcategoria " + subcategory, HttpStatus.FORBIDDEN);
        }
        return new ResponseEntity<>(productService.getBySubCategory(subcategory).stream().map(ProductDto::new)
                .collect(Collectors.toList()), HttpStatus.OK);
    }

    @GetMapping("/products/serie")
    public ResponseEntity<?> getBySerie(@RequestParam String serie){
        if(serie.isEmpty()){
            return new ResponseEntity<>("No ingreso ninguna serie", HttpStatus.FORBIDDEN);
        }
        if(!productService.existsBySerie(serie)){
            return new ResponseEntity<>("No existe ningun producto de la serie " + serie, HttpStatus.FORBIDDEN);
        }
        return new ResponseEntity<>(productService.getAllBySerie(serie).stream().map(ProductDto::new)
                .collect(Collectors.toList()), HttpStatus.OK);
    }
}
