package challenge.ecommerce.services;
import challenge.ecommerce.services.dtos.ClientDTO;
import challenge.ecommerce.models.Client;
import org.springframework.security.core.Authentication;

import java.util.List;

import challenge.ecommerce.core.exception.ClientAlreadyExistException;
import challenge.ecommerce.core.exception.InvalidTokenException;
import challenge.ecommerce.core.exception.UnkownIdentifierException;
import challenge.ecommerce.data.user.ClientData;

public interface ClientService {

    void register(final ClientData user) throws ClientAlreadyExistException;
    void sendRegistrationConfirmationEmail(Client client);

    boolean checkIfUserExist(final String email);
    boolean verifyUser(final String token) throws InvalidTokenException;
    Client getUserById(final String id) throws UnkownIdentifierException;

    List <ClientDTO> getClientsDTO();
    ClientDTO getClientDTO(Long id);
    Client getCurrentClient (Authentication authentication);
    void saveClient(Client client);
    Client findByEmail(String email);
    String encodePassword(String password);
}
