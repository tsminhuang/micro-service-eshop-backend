package cmpe282.microservice.review.controllers;

import cmpe282.microservice.review.domain.Review;
import cmpe282.microservice.review.services.ReviewService;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(ReviewController.BASE_URL)
public class ReviewController {

    public static final String BASE_URL = "/api/review";

    private ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Review> getListOfReviews() {
        return reviewService.findAllReviews();
    }

    @GetMapping({"/product/{productId}"})
    @ResponseStatus(HttpStatus.OK)
    public double getAvgReviewByProductId(@PathVariable String productId) {
        return reviewService.getAvgReviewByProductId(productId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Review addReview(@RequestBody Review review) {
        return reviewService.createNewReview(review);
    }

}
