package cmpe282.microservice.webui.servies;

import cmpe282.microservice.webui.domain.Customer;
import cmpe282.microservice.webui.domain.Product;
import cmpe282.microservice.webui.domain.Review;
import java.util.List;
import java.util.Set;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public interface WebService {

    List<Product> findAllProducts();

    Product getProductById(String id);

    Set<Product> getProductByKeyword(String keyword);

    Customer createNewCustomer(Customer customer);

    boolean authenticateUser(Customer customer);

    double getAvgReviewByProductId(String productId);

    Review createNewReview(Review review);
}
