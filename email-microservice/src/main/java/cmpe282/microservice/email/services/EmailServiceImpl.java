package cmpe282.microservice.email.services;

import cmpe282.microservice.email.config.EmailConfig;
import cmpe282.microservice.email.domain.Customer;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class EmailServiceImpl implements EmailService {


    private EmailConfig emailConfig;

    public EmailServiceImpl(EmailConfig emailConfig) {
        this.emailConfig = emailConfig;
    }

    private static final String REGISTER_EMAIL_TEMPLATE =
            "Dear User:                               \n" +
            "    Your register: %s                    \n" +
            "                                         \n" +
            "Sincerely                                \n" +
            "E-shop                                   \n";


    @Override
    public void sendToCustomer(Customer customer) {
        sendMail(customer.getEmail());

    }

    private void sendMail(String customerEmail) {

        try {

            log.info("Send email to: " + customerEmail);
            Message message = new MimeMessage(emailConfig.getSession());
            message.setFrom(new InternetAddress(emailConfig.getDefaultSender()));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(customerEmail));

            message.setSubject("E-shop register notification");
            message.setText(String.format(REGISTER_EMAIL_TEMPLATE, customerEmail));

            Transport.send(message);
            log.info("Send mail complete");

        } catch (MessagingException e) {
            log.info("Send email failed: " + e.toString());
            throw new RuntimeException(e);
        }
    }
}
