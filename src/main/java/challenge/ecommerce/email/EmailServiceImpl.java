package challenge.ecommerce.email;

import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
@AllArgsConstructor
public class EmailServiceImpl implements EmailService{

    private final static Logger LOGGER = LoggerFactory.getLogger(EmailServiceImpl.class);

    @Autowired
    private JavaMailSender mailSender;

    @Override
    @Async
    public void send(String to, String email) {
        try {
            MimeMessage mimeMessage = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "utf-8");
            helper.setText(email, true);
            helper.setTo(to);
            helper.setSubject("Please Verify your Account - noreply@xd.com");
            helper.setFrom("kobeestore05@gmail.com");
            mailSender.send(mimeMessage);
        }catch (MessagingException e){
            LOGGER.error("Failed to send the email", e);
            throw new IllegalStateException("Failed to send email");
        };
    }

    @Override
    public String createEmail(String name, String lastName, String link) {
        name = name.substring(0, 1).toUpperCase().concat(name.substring(1));
        lastName = lastName.substring(0, 1).toUpperCase().concat(lastName.substring(1));

        return "Hello " + name+" " + lastName+"," +" \n" +
                "Please Verify Your Account with this link" +"<a href=\"" + link + "\">Activate Now</a> </p></blockquote>\n This link will expire in 15 minutes. <p>Sincerely,</p>\n <p>Kobee Store S.A</p>" +
                "\n";
    }
}
