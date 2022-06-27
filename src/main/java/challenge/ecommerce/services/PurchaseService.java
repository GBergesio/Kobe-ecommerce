package challenge.ecommerce.services;

import challenge.ecommerce.dtos.PurchaseApplicationDto;
import challenge.ecommerce.dtos.PurchaseDto;
import challenge.ecommerce.models.Client;
import challenge.ecommerce.models.Purchase;
import org.springframework.security.core.Authentication;

import java.util.List;

public interface PurchaseService {
    void create(Client client, PurchaseApplicationDto purchaseApplicationDto);
    void save(Purchase purchase);
}
