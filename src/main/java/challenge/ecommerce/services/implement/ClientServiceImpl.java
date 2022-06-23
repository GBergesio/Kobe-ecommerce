package challenge.ecommerce.services.implement;

import challenge.ecommerce.models.Client;
import challenge.ecommerce.repositories.ClientRepository;
import challenge.ecommerce.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository clientRepository;
    @Override
    public Client getByEmail(String email) {
        return clientRepository.findByEmail(email);
    }
}
