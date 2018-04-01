package cmpe282.microservice.email;

import cmpe282.microservice.email.services.EmailService;
import cmpe282.microservice.email.services.RabbitMQReceiver;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EmailMicroserviceApplication {

    @Value("${customer.rabbitmq.queue}")
    String queueName;

    @Bean
    public MessageConverter jsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public SimpleMessageListenerContainer listenerContainer(ConnectionFactory connectionFactory,
        EmailService emailService) {
        SimpleMessageListenerContainer listenerContainer = new SimpleMessageListenerContainer();
        listenerContainer.setConnectionFactory(connectionFactory);
        listenerContainer.setQueueNames(queueName);
        listenerContainer.setMessageConverter(jsonMessageConverter());
        listenerContainer.setMessageListener(new RabbitMQReceiver(emailService));
        //listenerContainer.setAcknowledgeMode(AcknowledgeMode.AUTO);
        return listenerContainer;
    }

    public static void main(String[] args) {
        SpringApplication.run(EmailMicroserviceApplication.class, args);
    }
}
