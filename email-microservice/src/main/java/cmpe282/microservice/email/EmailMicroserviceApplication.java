package cmpe282.microservice.email;

import org.springframework.amqp.core.Queue;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EmailMicroserviceApplication {


	public static final String REGISTER_MSG_QUEUE = "register-msg-queue";
	public static final String ORDER_MSG_QUEUE    = "order-msg-queue";

	@Bean
	Queue queue() {
		return new Queue()
	}

	public static void main(String[] args) {
		SpringApplication.run(EmailMicroserviceApplication.class, args);
	}
}
