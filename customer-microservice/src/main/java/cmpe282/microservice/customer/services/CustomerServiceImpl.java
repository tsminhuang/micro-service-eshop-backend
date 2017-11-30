package cmpe282.microservice.customer.services;

import cmpe282.microservice.customer.domain.Customer;
import cmpe282.microservice.customer.repositories.CustomerRepository;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.Optional;


@Service
public class CustomerServiceImpl implements CustomerService {

    private CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }


    @Override
    public Customer createNewCustomer(Customer customer) {
        Optional<Customer> dbResult = customerRepository.findByEmail(customer.getEmail());
        if(dbResult.isPresent()) {
           return null;
        }

        // TODO: Call send email message
        return customerRepository.save(customer);
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
