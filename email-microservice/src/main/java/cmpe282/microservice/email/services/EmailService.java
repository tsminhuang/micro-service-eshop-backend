package cmpe282.microservice.email.services;

import cmpe282.microservice.email.domain.Customer;

public interface EmailService {

    void sendToCustomer(Customer customer);
}
