package challenge.ecommerce.services.implement;

import challenge.ecommerce.models.ConfirmationToken;
import challenge.ecommerce.repositories.ConfirmationTokenRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ConfirmationTokenImpl {

    @Autowired
    private ConfirmationTokenRepository confirmationTokenRepository;


    public void saveConfirmationToken(ConfirmationToken confirmationToken) {
        confirmationTokenRepository.save(confirmationToken);
    }

    public Optional<ConfirmationToken> getConfirmationToken(String token) {
        return confirmationTokenRepository.findByToken(token);
    }

    public int setTokenConfirmedAt(String token) {
        return confirmationTokenRepository.updateConfirmedAt(token, LocalDateTime.now());
    }
}
