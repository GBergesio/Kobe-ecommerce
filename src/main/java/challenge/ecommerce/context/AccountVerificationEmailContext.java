package challenge.ecommerce.context;

import challenge.ecommerce.models.Client;
import org.springframework.web.util.UriComponentsBuilder;

public class AccountVerificationEmailContext extends AbstractEmailContext{
    private String token;

    @Override
    public <T> void init(T context) {
        // we can do any common configuration setup here
        // like setting up some base URL and context
        Client customer = (Client) context; // we pass the customer informati
        put("firstName", customer.getName());
        setTemplateLocation("emails/email-verification");
        setSubject("Complete your registration");

        setFrom("testtune4@gmail.com");
        setTo(customer.getEmail());
    }

    public void setToken(String token) {
        this.token = token;
        put("token", token);
    }

    public void buildVerificationUrl(final String baseURL, final String token) {
        final String url = UriComponentsBuilder.fromHttpUrl(baseURL).path("/register/verify").queryParam("token", token)
                .toUriString();
        put("verificationURL", url);
    }
}
