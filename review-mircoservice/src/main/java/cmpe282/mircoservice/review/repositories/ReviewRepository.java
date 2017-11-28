package cmpe282.mircoservice.review.repositories;

import cmpe282.mircoservice.review.domain.Review;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ReviewRepository extends MongoRepository<Review, String> {

}
