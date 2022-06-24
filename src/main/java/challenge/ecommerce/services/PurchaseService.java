package challenge.ecommerce.services;

import challenge.ecommerce.models.Client;
import challenge.ecommerce.models.Purchase;

import java.util.HashMap;

public interface PurchaseService {
    void create(Client client, HashMap<Long,Integer> productsAndQuantity);
    void save(Purchase purchase);
}
