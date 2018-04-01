package cmpe282.microservice.customer.bootstrap;

import cmpe282.microservice.customer.domain.Customer;
import cmpe282.microservice.customer.repositories.CustomerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class CustomerBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private final CustomerRepository customerRepository;

    public CustomerBootstrap(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        customerRepository.deleteAll();
        loadCustomers();
    }

    private void loadCustomers() {
        Customer user1 = new Customer("user1@gmail.com", "user1pw");
        customerRepository.save(user1);

        Customer user2 = new Customer("user2@gmail.com", "user2pw");
        customerRepository.save(user2);
    }
}