package challenge.ecommerce.controllers;

import challenge.ecommerce.dtos.OrderDto;
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
import java.util.List;
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

        List<OrderDto> productOrders = purchaseApplicationDto.getOrders();
        if(productOrders.size() == 0){
            return new ResponseEntity<>("No cargo ordenes de compra", HttpStatus.FORBIDDEN);
        }
        if(productOrders.stream().anyMatch(order -> order.getProductId() <= 0 ||
                order.getQuantity() <= 0)){
            return new ResponseEntity<>("Alguna de las ordenes de compra contienen un valor invalido", HttpStatus.FORBIDDEN);
        }
//        productOrders.forEach(orderDto -> {
//            if(orderDto.getQuantity() <= 0 || orderDto.getProductId() <= 0){
//                return new ResponseEntity<>("Uno o muchos de los productId o cantidad de productos son invalidos", HttpStatus.FORBIDDEN);
//            }
//            Product product = productService.getById(orderDto.getProductId());
//            if(product == null || product.getStock() < orderDto.getQuantity()){
//
//            }
//        });
        boolean isThereAnyInvalid = productOrders.stream().anyMatch(order ->{
            if(order.getQuantity() <= 0 || order.getProductId() <= 0){
                return true;
            }
            Product product = productService.getById(order.getProductId());
            if(product == null || product.getStock() < order.getQuantity()){
                return true;
            }
            return false;
        });

        if(isThereAnyInvalid){
            return new ResponseEntity<>("Uno o varios de los productos o cantidades son invalidos", HttpStatus.FORBIDDEN);
        }
        purchaseService.create(client,purchaseApplicationDto);
        return new ResponseEntity<>("Purchase created successfully", HttpStatus.CREATED);
    }
}
