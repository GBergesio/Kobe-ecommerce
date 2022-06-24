package challenge.ecommerce.controllers;

import challenge.ecommerce.dtos.PurchaseDto;
import challenge.ecommerce.models.Client;
import challenge.ecommerce.models.Product;
import challenge.ecommerce.models.Purchase;
import challenge.ecommerce.models.PurchaseProduct;
import challenge.ecommerce.repositories.PurchaseProductRepository;
import challenge.ecommerce.repositories.PurchaseRepository;
import challenge.ecommerce.services.ClientService;
import challenge.ecommerce.services.ProductService;
import challenge.ecommerce.services.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class PurchaseController {
    @Autowired
    private PurchaseService purchaseService;

    @Autowired
    private ProductService productService;

    @Autowired
    private PurchaseProductRepository purchaseProductRepository;
    @Autowired
    private PurchaseRepository purchaseRepository;
    @Autowired
    private ClientService clientService;

    //borrar
    @GetMapping("/purchases")
    public ResponseEntity<?> getAll(){
        return new ResponseEntity<>(purchaseRepository.findAll().stream().map(PurchaseDto::new).collect(Collectors.toList()),
                HttpStatus.OK);
    }

    @PostMapping("/purchases")
    @Transactional
    public ResponseEntity<?> create(Authentication authentication, @RequestBody HashMap<Long, Integer> purchaseApplication){
        Client client = clientService.getByEmail(authentication.getName());
        if(purchaseApplication.size() == 0){
            return new ResponseEntity<>("Missing data", HttpStatus.FORBIDDEN);
        }
        for (Map.Entry<Long, Integer> order : purchaseApplication.entrySet()) {
            Product product = productService.getById(order.getKey());
            if (product == null){
                return new ResponseEntity<>("One or many products do not exist", HttpStatus.FORBIDDEN);
            }
            if(product.getStock() < order.getValue()){
                return new ResponseEntity<>("The ordered quantity of one or several products exceeds the stock of the product",
                        HttpStatus.FORBIDDEN);
            }
        }
        purchaseService.create(client,purchaseApplication);
        return new ResponseEntity<>("Purchase created successfully", HttpStatus.CREATED);
    }
}
