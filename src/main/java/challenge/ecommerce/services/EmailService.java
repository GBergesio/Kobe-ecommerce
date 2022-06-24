package challenge.ecommerce.services;

import challenge.ecommerce.context.AbstractEmailContext;

import javax.mail.MessagingException;

public interface EmailService {
    void sendEmail(final AbstractEmailContext email) throws MessagingException;
}
