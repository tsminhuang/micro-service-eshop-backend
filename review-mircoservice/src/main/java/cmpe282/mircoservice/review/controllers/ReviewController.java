package cmpe282.mircoservice.review.controllers;

import cmpe282.mircoservice.review.services.ReviewService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/api/review")
public class ReviewController {

    private ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    // TODO: Add reivew

    @RequestMapping("/add/{productId}/{customerId}")
    public void addReview(@PathVariable String productId, @PathVariable  String customerId) {

    }

    // TODO: Query review by productId

    // TODO: Query rating by proudctId


}
