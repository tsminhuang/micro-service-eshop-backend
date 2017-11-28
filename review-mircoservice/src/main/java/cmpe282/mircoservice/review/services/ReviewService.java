package cmpe282.mircoservice.review.services;

import java.util.List;
import org.bson.types.ObjectId;

public interface ReviewService {

    double getAvgRatingByProductId(ObjectId productId);

    List<String> getReviewByProductId(ObjectId productId);

    List<Integer> getRatingByProductId(ObjectId proudctId);

    List<String> getReviewByCustomerId(ObjectId customerId);

    List<Integer> getRatingByCusotmerId(ObjectId customerId);
}
