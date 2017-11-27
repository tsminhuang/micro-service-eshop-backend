package cmpe282.mircroservice.product.repositories;

import cmpe282.mircroservice.product.domain.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, String> {

}
