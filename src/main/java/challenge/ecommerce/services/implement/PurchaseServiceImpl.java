package challenge.ecommerce.services.implement;

import challenge.ecommerce.dtos.PurchaseApplicationDto;
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
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class PurchaseServiceImpl implements PurchaseService {
    @Autowired
    private PurchaseRepository purchaseRepository;
    @Autowired
    private PurchaseProductRepository purchaseProductRepository;
    @Autowired
    private ProductService productService;
    @Autowired
    private ClientService clientService;
    @Override
    public void create(Client client, PurchaseApplicationDto purchaseApplicationDto) {
        Purchase purchase = purchaseRepository.save(new Purchase( purchaseApplicationDto.getTotalAmount(),purchaseApplicationDto.getTypePayment(),LocalDateTime.now(),
                purchaseApplicationDto.getAddress(), Integer.valueOf(purchaseApplicationDto.getZipCode())));

        for (Map.Entry<Long, Integer> order : purchaseApplicationDto.getOrders().entrySet()) {
            Product product = productService.getById(order.getKey());
            purchaseProductRepository.save(new PurchaseProduct(purchase, product, order.getValue()));
            product.setStock((short)(product.getStock() - order.getValue()));
            productService.save(product);
//            purchase.addPurchaseProduct(purchaseProduct);
        }

        purchaseRepository.save(purchase);
        client.addPurchase(purchase);
        clientService.saveClient(client);
    }

    @Override
    public void save(Purchase purchase) {
        purchaseRepository.save(purchase);
    }

    @Override
    public List<PurchaseDto> getCurrentClientPurchasesDto(Authentication authentication) {
        return clientService.getCurrentClient(authentication).getPurchases().stream().map(PurchaseDto::new).collect(Collectors.toList());
    }
}
