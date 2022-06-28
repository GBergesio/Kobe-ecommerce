package challenge.ecommerce.services.implement;


import challenge.ecommerce.dtos.ClientDTO;
import challenge.ecommerce.email.EmailServiceImpl;
import challenge.ecommerce.models.Client;
import challenge.ecommerce.models.ConfirmationToken;
import challenge.ecommerce.models.RegistrationRequest;
import challenge.ecommerce.repositories.ClientRepository;
import challenge.ecommerce.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;


@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    ConfirmationTokenImpl confirmationTokenImpl;

    @Autowired
    EmailServiceImpl emailServiceImpl;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    public List<ClientDTO> getClientsDTO() {
        return clientRepository.findAll().stream().map(ClientDTO::new).collect(Collectors.toList());
    }

    @Override
    public ClientDTO getClientDTO(Long id) {
        return clientRepository.findById(id).map(ClientDTO::new).orElse(null);
    }

    @Override
    public Client getCurrentClient(Authentication authentication) {
        return clientRepository.findByEmail(authentication.getName());
    }

    @Override
    public void saveClient(Client client) {
        clientRepository.save(client);

    }

    @Override
    public Client findByEmail(String email){
        return clientRepository.findByEmail(email);
    }

    @Override
    public String encodePassword(String password) {
        return passwordEncoder.encode(password);
    }

    @Override
    public boolean createClient(RegistrationRequest request) {

        Client client = new Client(request.getName(), request.getLastName(), request.getEmail(), passwordEncoder.encode(request.getPassword()));
        clientRepository.save(client);

        String token = UUID.randomUUID().toString();
        ConfirmationToken confirmationToken = new ConfirmationToken(token, LocalDateTime.now(), LocalDateTime.now().plusMinutes(15), client);
        confirmationTokenImpl.saveConfirmationToken(confirmationToken);

        String link = "http://localhost:8080/api/clients/confirm?token=" + token;
        String email = emailServiceImpl.createEmail(request.getName(),request.getLastName(), link);
        emailServiceImpl.send(request.getEmail(), email);

        return true;

    }

    @Override
    public int enableClient(String email) {return clientRepository.enableClient(email);}

    @Transactional
    public String confirmClientEmail(String token) {

        ConfirmationToken confirmationToken = confirmationTokenImpl.getConfirmationToken(token).orElse(null);
        if (confirmationToken == null) return "token not found";
        if (confirmationToken.getConfirmedAt() != null) return "email already confirmed";

        LocalDateTime expiredAt = confirmationToken.getExpiresAt();
        if (expiredAt.isBefore(LocalDateTime.now())) return "token expired";

        confirmationTokenImpl.setTokenConfirmedAt(token);
        enableClient(confirmationToken.getClient().getEmail());
        return "confirmed";
    }
}
