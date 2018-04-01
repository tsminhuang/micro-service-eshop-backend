package cmpe282.microservice.customer.repositories;

import cmpe282.microservice.customer.domain.Customer;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerRepository extends MongoRepository<Customer, String> {

    Optional<Customer> findByEmail(String email);
}
