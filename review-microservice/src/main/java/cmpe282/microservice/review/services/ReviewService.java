package cmpe282.microservice.review.services;

import cmpe282.microservice.review.domain.Review;
import java.util.List;

public interface ReviewService {

    List<Review> findAllReviews();

    Review createNewReview(Review review);

    double getAvgReviewByProductId(String productId);

}
