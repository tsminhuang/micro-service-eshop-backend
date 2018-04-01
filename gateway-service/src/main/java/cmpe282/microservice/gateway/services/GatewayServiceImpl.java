package cmpe282.microservice.gateway.services;

import cmpe282.microservice.gateway.domain.Customer;
import cmpe282.microservice.gateway.domain.Product;
import cmpe282.microservice.gateway.domain.Review;
import java.util.List;
import java.util.Set;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Slf4j
@Service
public class GatewayServiceImpl implements GatewayService {

    @Value("${rest.api.product}")
    private String PRODUCT_URL;
    @Value("${rest.api.customer}")
    private String CUSTOMER_URL;
    @Value("${rest.api.review}")
    private String REVIEW_URL;

    private RestTemplate restTemplate = new RestTemplate();

    @Override
    public List<Product> findAllProducts() {
        return getListOfObject(PRODUCT_URL);
    }

    @Override
    public Product getProductById(String id) {
        UriComponentsBuilder uriBuilder = createRestUri(PRODUCT_URL, id);
        log.info("Route to :" + uriBuilder.toUriString());

        return restTemplate.getForObject(uriBuilder.toUriString(), Product.class);
    }

    @Override
    public Set<Product> getProductByKeyword(String keyword) {
        UriComponentsBuilder uriBuilder = createRestUri(PRODUCT_URL + "/search", keyword);
        log.info("Route to :" + uriBuilder.toUriString());

        ParameterizedTypeReference<Set<Product>> params =
            new ParameterizedTypeReference<Set<Product>>() {
            };
        ResponseEntity<Set<Product>> response =
            restTemplate.exchange(uriBuilder.toUriString(), HttpMethod.GET, null, params);

        return response.getBody();
    }

    @Override
    public List<Customer> findAllCustomers() {
        return getListOfObject(CUSTOMER_URL);
    }

    @Override
    public Customer createNewCustomer(Customer customer) {
        log.info("Route to :" + CUSTOMER_URL);
        return restTemplate.postForObject(CUSTOMER_URL, customer, Customer.class);
    }

    @Override
    public boolean authenticateUser(Customer customer) {
        log.info("Route to :" + CUSTOMER_URL + "/auth");

        return restTemplate.postForObject(CUSTOMER_URL + "/auth", customer, boolean.class);
    }

    @Override
    public List<Review> findAllReviews() {
        return getListOfObject(REVIEW_URL);
    }

    @Override
    public double getAvgReviewByProductId(String productId) {
        UriComponentsBuilder uriBuilder = createRestUri(REVIEW_URL + "/product", productId);
        log.info("Route to :" + uriBuilder.toUriString());
        return restTemplate.getForObject(uriBuilder.toUriString(), double.class);
    }

    @Override
    public Review createNewReview(Review review) {
        log.info("Route to :" + REVIEW_URL);
        return restTemplate.postForObject(REVIEW_URL, review, Review.class);
    }

    private UriComponentsBuilder createRestUri(String apiUri, String value) {
        return UriComponentsBuilder.fromUriString(apiUri).pathSegment(value);
    }

    private <T> List<T> getListOfObject(String uri) {
        log.info("Route to :" + uri);
        ParameterizedTypeReference<List<T>> params =
            new ParameterizedTypeReference<List<T>>() {
            };
        ResponseEntity<List<T>> response =
            restTemplate.exchange(uri, HttpMethod.GET, null, params);

        return response.getBody();
    }
}
