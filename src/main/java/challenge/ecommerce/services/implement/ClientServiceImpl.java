package challenge.ecommerce.services.implement;

//<<<<<<< HEAD
//import challenge.ecommerce.context.AccountVerificationEmailContext;
//import challenge.ecommerce.core.exception.ClientAlreadyExistException;
//import challenge.ecommerce.core.exception.InvalidTokenException;
//import challenge.ecommerce.core.exception.UnkownIdentifierException;
//import challenge.ecommerce.data.user.ClientData;
//import challenge.ecommerce.models.Client;
//import challenge.ecommerce.models.SecureToken;
//import challenge.ecommerce.repositories.ClientRepository;
//import challenge.ecommerce.repositories.SecureTokenRepository;
//import challenge.ecommerce.services.ClientService;
//import challenge.ecommerce.services.EmailService;
//import challenge.ecommerce.services.SecureTokenService;
//import org.apache.commons.lang3.BooleanUtils;
//import org.springframework.beans.BeanUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
//import org.thymeleaf.util.StringUtils;
//
//import javax.mail.MessagingException;
//import java.util.Objects;
//=======
import challenge.ecommerce.dtos.ClientDTO;
import challenge.ecommerce.models.Client;
import challenge.ecommerce.repositories.ClientRepository;
import challenge.ecommerce.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
//>>>>>>> backgentile

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    ClientRepository clientRepository;

//<<<<<<< HEAD
//    @Autowired
//    private PasswordEncoder passwordEncoder;
//
//    @Autowired
//    private EmailService emailService;
//
//    @Autowired
//    private SecureTokenService secureTokenService;
//
//    @Autowired
//    SecureTokenRepository secureTokenRepository;
//
//    @Value("${site.base.url.https}")
//    private String baseURL;
//
//
//    @Override
//    public void register(ClientData client) throws ClientAlreadyExistException {
//        if(checkIfUserExist(client.getEmail())){
//            throw new ClientAlreadyExistException("Client  already Exists for this email!");
//        }
//        Client user = new Client();
//        BeanUtils.copyProperties(client, user);
//        encodePassword(client, user);
//        clientRepository.save(user);
//        sendRegistrationConfirmationEmail(user);
//    }
//
//
//    @Override
//    public void sendRegistrationConfirmationEmail(Client client){
//        SecureToken secureToken = secureTokenService.createSecureToken();
//        secureToken.setUser(client);
//        secureTokenRepository.save(secureToken);
//        AccountVerificationEmailContext emailContext = new AccountVerificationEmailContext();
//        emailContext.init(client);
//        emailContext.setToken(secureToken.getToken());
//        emailContext.buildVerificationUrl(baseURL, secureToken.getToken());
//
//        try{
//            emailService.sendEmail(emailContext);
//        }catch (MessagingException messagingException){
//            messagingException.printStackTrace();
//        }
//
//    };
//
//    private void encodePassword(ClientData source, Client target){
//        target.setPassword(passwordEncoder.encode(source.getPassword()));
//=======
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
//>>>>>>> backgentile
//    }
//
    @Override
    public Client findByEmail(String email) {
        return clientRepository.findByEmail(email);
    }
//<<<<<<< HEAD


//    @Override
//    public boolean checkIfUserExist(String email) {
//        return clientRepository.findByEmail(email)!=null ? true : false;
//    }
//
//    @Override
//    public boolean verifyUser(String token) throws InvalidTokenException {
//        SecureToken secureToken = secureTokenService.findByToken(token);
//        if (Objects.isNull(secureToken) || !StringUtils.equals(token, secureToken.getToken())
//                || secureToken.isExpired()) {
//            throw new InvalidTokenException("Token is not valid");
//        }
//        Client user = clientRepository.getReferenceById(secureToken.getUser().getId());
//        if (Objects.isNull(user)) {
//            return false;
//        }
//        user.setActive(true);
//        clientRepository.save(user); // let’s same user details
//
//        // we don’t need invalid password now
//        secureTokenService.removeToken(secureToken);
//        return true;
//    }
//
//    @Override
//    public Client getUserById(String id) throws UnkownIdentifierException {
//        Client user = clientRepository.findByEmail(id);
//        if (user == null || BooleanUtils.isFalse(user.isActive())) {
//            // we will ignore in case account is not verified or account does not exists
//            throw new UnkownIdentifierException("unable to find account or account is not active");
//        }
//        return user;
//    }
//=======
//>>>>>>> backgentile
}
