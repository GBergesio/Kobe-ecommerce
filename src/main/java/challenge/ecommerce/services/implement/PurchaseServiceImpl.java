package challenge.ecommerce.services.implement;

import challenge.ecommerce.dtos.PurchaseApplicationDto;
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
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

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
        Purchase purchase = purchaseRepository.save(new Purchase( purchaseApplicationDto.getTotalAmount(),
                purchaseApplicationDto.getTypePayment(),LocalDateTime.now(),
                purchaseApplicationDto.getAddress(), Integer.valueOf(purchaseApplicationDto.getZipCode())));

        purchaseApplicationDto.getOrders().forEach(order -> {
            Product product = productService.getById(order.getProductId());
            purchaseProductRepository.save(new PurchaseProduct(purchase, product,(int) order.getQuantity()));
            product.setStock((short)(product.getStock() - order.getQuantity()));
            productService.save(product);
        });

        purchaseRepository.save(purchase);
        client.addPurchase(purchase);
        clientService.saveClient(client);
    }

    @Override
    public void save(Purchase purchase) {
        purchaseRepository.save(purchase);
    }

    @Override
    public List<Purchase> getAll() {
        return purchaseRepository.findAll();
    }


}
