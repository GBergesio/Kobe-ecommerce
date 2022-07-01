package challenge.ecommerce.services;

import challenge.ecommerce.dtos.PurchaseApplicationDto;
import challenge.ecommerce.models.Client;
import challenge.ecommerce.models.Purchase;

import java.util.List;

public interface PurchaseService {
    void create(Client client, PurchaseApplicationDto purchaseApplicationDto);
    void save(Purchase purchase);
    List<Purchase> getAll();
}
