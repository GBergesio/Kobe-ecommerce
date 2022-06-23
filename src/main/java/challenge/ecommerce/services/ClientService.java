package challenge.ecommerce.services;

import challenge.ecommerce.models.Client;

public interface ClientService {
    Client getByEmail(String email);
}
