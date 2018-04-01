package cmpe282.microservice.email.services;

import cmpe282.microservice.email.domain.Customer;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.concurrent.CountDownLatch;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class RabbitMQReceiver implements MessageListener {

    private EmailService emailService;

    public RabbitMQReceiver(EmailService emailService) {
        this.emailService = emailService;
    }

    @Override
    public void onMessage(Message message) {
        log.info("Recv newCustomer msg");
        CountDownLatch latch = new CountDownLatch(1);

        String jsonMsg = new String(message.getBody());
        Customer customer = fromJsonToCustomer(jsonMsg);

        emailService.sendToCustomer(customer);

        latch.countDown();

    }

    private Customer fromJsonToCustomer(String json) {
        ObjectMapper mapper = new ObjectMapper();
        Customer customer = null;
        try {
            customer = mapper.readValue(json, Customer.class);
        } catch (IOException e) {
            log.error("Customer Object deserialize failed");
            e.printStackTrace();
        }

        return customer;
    }
}
