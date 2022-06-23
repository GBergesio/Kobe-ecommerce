package challenge.ecommerce.services;

import challenge.ecommerce.dtos.ClientDTO;
import challenge.ecommerce.models.Client;
import org.springframework.security.core.Authentication;

import java.util.List;

public interface ClientService {

    List <ClientDTO> getClientsDTO();
    ClientDTO getClientDTO(Long id);
    Client getCurrentClient (Authentication authentication);
    void saveClient(Client client);
    Client findByEmail(String email);

}
