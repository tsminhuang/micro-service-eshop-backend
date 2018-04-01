package cmpe282.microservice.review.services;

import cmpe282.microservice.review.domain.Review;
import cmpe282.microservice.review.repositories.ReviewRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ReviewServiceImpl implements ReviewService {

    private ReviewRepository reviewRepository;

    public ReviewServiceImpl(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @Override
    public List<Review> findAllReviews() {
        return reviewRepository.findAll();
    }

    @Override
    public double getAvgReviewByProductId(String productId) {
        List<Review> reviews = reviewRepository.findByProductId(productId);

        return reviews.stream().mapToDouble(Review::getRating).average().orElse(0.0);
    }

    @Override
    public Review createNewReview(Review review) {
        return reviewRepository.save(review);
    }
}
