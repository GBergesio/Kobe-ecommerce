package challenge.ecommerce.controllers;

import challenge.ecommerce.dtos.PurchaseApplicationDto;
import challenge.ecommerce.dtos.PurchaseDto;
import challenge.ecommerce.models.Client;
import challenge.ecommerce.models.Product;
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
    private ClientService clientService;

    //borrar
    @GetMapping("/purchases")
    public ResponseEntity<?> getAll(){
        return new ResponseEntity<>(purchaseService.getAll().stream().map(PurchaseDto::new).collect(Collectors.toList()),
                HttpStatus.OK);
    }

    @PostMapping("/purchases")
    @Transactional
    public ResponseEntity<?> create(Authentication authentication, @RequestBody PurchaseApplicationDto purchaseApplicationDto){
        Client client = clientService.findByEmail(authentication.getName());
        if(!client.isActive()){
            return new ResponseEntity<>("Primero debes activar tu cuenta para realizar compras, revisa tu email", HttpStatus.FORBIDDEN);
        }
        if(purchaseApplicationDto.getOrders().size() == 0){
            return new ResponseEntity<>("Missing products data", HttpStatus.FORBIDDEN);
        }

        if(purchaseApplicationDto.getAddress().isEmpty() || purchaseApplicationDto.getZipCode().isEmpty()){
            return new ResponseEntity<>("Missing address data", HttpStatus.FORBIDDEN);
        }

        for (Map.Entry<Long, Integer> order : purchaseApplicationDto.getOrders().entrySet()) {
            Product product = productService.getById(order.getKey());
            if (product == null){
                return new ResponseEntity<>("One or many products do not exist", HttpStatus.FORBIDDEN);
            }
            if(product.getStock() < order.getValue()){
                return new ResponseEntity<>("The ordered quantity of one or several products exceeds the stock of the product",
                        HttpStatus.FORBIDDEN);
            }
        }
        purchaseService.create(client,purchaseApplicationDto);
        return new ResponseEntity<>("Purchase created successfully", HttpStatus.CREATED);
    }
}
