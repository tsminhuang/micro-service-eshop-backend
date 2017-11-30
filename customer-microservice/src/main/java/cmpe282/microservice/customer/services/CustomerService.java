package cmpe282.microservice.customer.services;

import cmpe282.microservice.customer.domain.Customer;

public interface CustomerService {

    boolean authenticateCustomer(Customer customer);

    Customer createNewCustomer(Customer customer);


}
