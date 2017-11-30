package cmpe282.microservice.customer.services;

import cmpe282.microservice.customer.domain.Customer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class RabbitMQSenderImpl implements RabbitMQSender {

    @Autowired
    private AmqpTemplate amqpTemplate;

    public RabbitMQSenderImpl(AmqpTemplate amqpTemplate) {
        this.amqpTemplate = amqpTemplate;
    }

    @Value("${customer.rabbitmq.exchange}")
    private String exchange;

    @Value("${customer.rabbitmq.routingkey}")
    private String routingkey;

    @Override
    public void sendNewCustomerNotify(Customer customer) {
        log.info("Sending new customer info");
        amqpTemplate.convertAndSend(exchange, routingkey, customer);
        log.info("Customer send" + customer);
    }
}
