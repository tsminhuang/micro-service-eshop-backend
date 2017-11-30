package cmpe282.microservice.review.repositories;

import cmpe282.microservice.review.domain.Review;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ReviewRepository extends MongoRepository<Review, String> {

    List<Review> findByProductId(String productId);
}
