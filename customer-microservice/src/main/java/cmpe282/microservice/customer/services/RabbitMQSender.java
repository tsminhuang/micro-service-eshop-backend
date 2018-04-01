package cmpe282.microservice.customer.services;

import cmpe282.microservice.customer.domain.Customer;

public interface RabbitMQSender {

    void sendNewCustomerNotify(Customer customer);
}
