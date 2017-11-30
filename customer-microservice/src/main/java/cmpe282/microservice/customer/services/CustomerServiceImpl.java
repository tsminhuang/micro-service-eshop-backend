package cmpe282.microservice.customer.services;

import cmpe282.microservice.customer.domain.Customer;
import cmpe282.microservice.customer.repositories.CustomerRepository;
import java.util.Optional;
import org.springframework.stereotype.Service;


@Service
public class CustomerServiceImpl implements CustomerService {

    private CustomerRepository customerRepository;

    private RabbitMQSender rabbitMQSender;

    public CustomerServiceImpl(CustomerRepository customerRepository, RabbitMQSender rabbitMQSender) {
        this.customerRepository = customerRepository;
        this.rabbitMQSender = rabbitMQSender;
    }

    @Override
    public Customer createNewCustomer(Customer customer) {
        Optional<Customer> dbResult = customerRepository.findByEmail(customer.getEmail());
        if (dbResult.isPresent()) {
            return null;
        }
        Customer newCustomer = customerRepository.save(customer);
        rabbitMQSender.sendNewCustomerNotify(customer);
        return newCustomer;
    }


    @Override
    public boolean authenticateCustomer(Customer customer) {
        Optional<Customer> dbResult = customerRepository.findByEmail(customer.getEmail());
        if (!dbResult.isPresent()) {
            return false;
        }

        Customer customerInDB = dbResult.get();
        return customerInDB.getPassword().equals(customer.getPassword());
    }
}
