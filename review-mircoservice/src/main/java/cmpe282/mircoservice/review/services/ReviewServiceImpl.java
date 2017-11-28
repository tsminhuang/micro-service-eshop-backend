package cmpe282.mircoservice.review.services;

import java.util.List;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

@Service
public class ReviewServiceImpl implements ReviewService {


    @Override
    public double getAvgRatingByProductId(ObjectId productId) {
        return 0;
    }

    @Override
    public List<String> getReviewByProductId(ObjectId productId) {
        return null;
    }

    @Override
    public List<Integer> getRatingByProductId(ObjectId proudctId) {
        return null;
    }

    @Override
    public List<String> getReviewByCustomerId(ObjectId customerId) {
        return null;
    }

    @Override
    public List<Integer> getRatingByCusotmerId(ObjectId customerId) {
        return null;
    }
}
