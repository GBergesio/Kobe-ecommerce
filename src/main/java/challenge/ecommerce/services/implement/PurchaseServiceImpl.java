package challenge.ecommerce.services.implement;

import challenge.ecommerce.models.Client;
import challenge.ecommerce.models.Product;
import challenge.ecommerce.models.Purchase;
import challenge.ecommerce.models.PurchaseProduct;
import challenge.ecommerce.repositories.PurchaseProductRepository;
import challenge.ecommerce.repositories.PurchaseRepository;
import challenge.ecommerce.services.ProductService;
import challenge.ecommerce.services.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class PurchaseServiceImpl implements PurchaseService {
    @Autowired
    private PurchaseRepository purchaseRepository;
    @Autowired
    private PurchaseProductRepository purchaseProductRepository;
    @Autowired
    private ProductService productService;
    @Override
    public void create(Client client, HashMap<Long, Integer> purchaseApplication) {
        Purchase purchase = purchaseRepository.save(new Purchase());
        for (Map.Entry<Long, Integer> order : purchaseApplication.entrySet()) {
            Product product = productService.getById(order.getKey());
            PurchaseProduct purchaseProduct = purchaseProductRepository.save(new PurchaseProduct(purchase,
                    product, order.getValue()));
            product.setStock(product.getStock() - order.getValue());
            productService.save(product);
            purchase.addPurchaseProduct(purchaseProduct);
        }
        purchaseRepository.save(purchase);
    }

    @Override
    public void save(Purchase purchase) {
        purchaseRepository.save(purchase);
    }
}
