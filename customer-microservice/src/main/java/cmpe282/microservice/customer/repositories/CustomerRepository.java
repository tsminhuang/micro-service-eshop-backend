package cmpe282.microservice.customer.repositories;

import cmpe282.microservice.customer.domain.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface CustomerRepository extends MongoRepository<Customer, String> {

    Optional<Customer> findByEmail(String email);
}
