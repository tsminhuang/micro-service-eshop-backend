package cmpe282.microservice.review.services;

import cmpe282.microservice.review.domain.Review;

public interface ReviewService {

    Review add(Review review);

    double getProductAvgRatingByProductId(String productId);

}
