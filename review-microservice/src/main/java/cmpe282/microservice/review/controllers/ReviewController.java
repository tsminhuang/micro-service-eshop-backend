package cmpe282.microservice.review.controllers;

import cmpe282.microservice.review.domain.Review;
import cmpe282.microservice.review.services.ReviewService;
import java.awt.PageAttributes.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController("/api/review")
public class ReviewController {

    private ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @RequestMapping(method = RequestMethod.POST)
    public Review addReview(@RequestBody Review review) {
        return reviewService.add(review);
    }

    @RequestMapping(value = "/product/{productId}", method = RequestMethod.GET)
    public Double getProductAvgRatingByProductId(@PathVariable String productId) {
        return reviewService.getProductAvgRatingByProductId(productId);
    }

}
