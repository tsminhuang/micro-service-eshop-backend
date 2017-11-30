package cmpe282.microservice.email.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class RabbitMQReceiver implements MessageListener {

    @Autowired
    private EmailService emailService;

    @Override
    public void onMessage(Message message) {
        log.info("RECV " + new String(message.getBody()));

        // TODO: deserialize with json object

        // TODO: Send mail function
    }
}
