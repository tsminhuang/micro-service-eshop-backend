package cmpe282.microservice.customer.services;

import cmpe282.microservice.customer.domain.Customer;
import java.util.List;

public interface CustomerService {

    List<Customer> findAllCustomers();

    Customer createNewCustomer(Customer customer);

    boolean authenticateCustomer(Customer customer);
}
