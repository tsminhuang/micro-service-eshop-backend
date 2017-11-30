package cmpe282.mircroservice.repository;

import cmpe282.mircroservice.model.Checkout;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CheckoutRepository extends MongoRepository<Checkout,String> {

}

