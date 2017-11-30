package cmpe282.microservice.review.bootstrap;

import cmpe282.microservice.review.domain.Review;
import cmpe282.microservice.review.repositories.ReviewRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ReviewBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private final ReviewRepository reviewRepository;

    public ReviewBootstrap(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        loadReviews();
    }

    private void loadReviews() {
        reviewRepository.deleteAll();

        String aProducId = UUID.randomUUID().toString();
        List<Review> reviews = buildReviewForProduct(aProducId, 5);
        reviewRepository.saveAll(reviews);

        String bProductId = UUID.randomUUID().toString();
        reviews = buildReviewForProduct(bProductId, 10);
        reviewRepository.saveAll(reviews);
    }

    private List<Review> buildReviewForProduct(String productId, int numReview) {
        final List<Review> reviews = new ArrayList<>(numReview);
        final Random random = new Random();
        for (int i = 0; i < numReview; i++) {
            reviews.add(new Review(productId, UUID.randomUUID().toString(), (double) random.nextInt(5)));
        }

        return reviews;
    }
}
