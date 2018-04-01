package cmpe282.microservice.gateway.services;

import cmpe282.microservice.gateway.domain.Customer;
import cmpe282.microservice.gateway.domain.Product;
import cmpe282.microservice.gateway.domain.Review;
import java.util.List;
import java.util.Set;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public interface GatewayService {

    List<Product> findAllProducts();

    Product getProductById(String id);

    Set<Product> getProductByKeyword(String keyword);

    List<Customer> findAllCustomers();

    Customer createNewCustomer(Customer customer);

    boolean authenticateUser(Customer customer);

    List<Review> findAllReviews();

    double getAvgReviewByProductId(String productId);

    Review createNewReview(Review review);

}
