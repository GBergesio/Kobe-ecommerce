package challenge.ecommerce.services.implement;

import challenge.ecommerce.models.Client;
import challenge.ecommerce.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomClientDetailServiceImpl implements UserDetailsService {

    @Autowired
    ClientRepository clientRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        final Client client = clientRepository.findByEmail(email);

        if(client == null) {
            throw new UsernameNotFoundException(email);
        }
        boolean enabled = !client.isActive();

        UserDetails  user = User.withUsername(client.getEmail())
                .password(client.getPassword())
                .disabled(enabled)
                .authorities("CLIENT").build();

        return user;
    }
}
