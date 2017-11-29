package cmpe282.microservice.product.repositories;

import cmpe282.microservice.product.domain.Product;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, String> {

    List<Product> findByNameLikeOrCategoryLikeOrDescriptionLikeAllIgnoreCase(String name, String category,
        String description);

    default List<Product> findByKeyword(String keyword) {
        return findByNameLikeOrCategoryLikeOrDescriptionLikeAllIgnoreCase(keyword, keyword, keyword);
    }
}
