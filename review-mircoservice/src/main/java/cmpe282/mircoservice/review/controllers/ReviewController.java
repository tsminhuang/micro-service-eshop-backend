package cmpe282.mircoservice.review.controllers;

import cmpe282.mircoservice.review.services.ReviewService;
import org.springframework.web.bind.annotation.RestController;

@RestController("/api/review")
public class ReviewController {

    private ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    // TODO: Add reivew

    // TODO: Query review by productId

    // TODO: Query rating by proudctId


}
