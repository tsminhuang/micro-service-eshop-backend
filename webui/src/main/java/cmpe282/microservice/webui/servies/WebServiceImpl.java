package cmpe282.microservice.webui.servies;

import cmpe282.microservice.webui.domain.Customer;
import cmpe282.microservice.webui.domain.Product;
import cmpe282.microservice.webui.domain.Review;
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
public class WebServiceImpl implements WebService {

    @Value("${gateway.url}")
    private String GATEWAY_URL;

    private RestTemplate restTemplate = new RestTemplate();

    @Override
    public List<Product> findAllProducts() {
        return getListOfObject(GATEWAY_URL + "/product");
    }

    @Override
    public Product getProductById(String id) {
        UriComponentsBuilder uriBuilder = createRestUri(GATEWAY_URL + "/product", id);
        log.info("Route to :" + uriBuilder.toUriString());

        return restTemplate.getForObject(uriBuilder.toUriString(), Product.class);
    }

    @Override
    public Set<Product> getProductByKeyword(String keyword) {
        UriComponentsBuilder uriBuilder = createRestUri(GATEWAY_URL + "/product/search", keyword);
        log.info("Route to :" + uriBuilder.toUriString());

        ParameterizedTypeReference<Set<Product>> params =
            new ParameterizedTypeReference<Set<Product>>() {
            };
        ResponseEntity<Set<Product>> response =
            restTemplate.exchange(uriBuilder.toUriString(), HttpMethod.GET, null, params);

        return response.getBody();
    }

    @Override
    public Customer createNewCustomer(Customer customer) {
        return null;
    }

    @Override
    public boolean authenticateUser(Customer customer) {
        log.info("Route to :" + GATEWAY_URL + "/customer" + "/auth");

        return restTemplate.postForObject( GATEWAY_URL + "/customer" + "/auth", customer, boolean.class);
    }

    @Override
    public double getAvgReviewByProductId(String productId) {
        UriComponentsBuilder uriBuilder = createRestUri(GATEWAY_URL + "/review/product", productId);
        log.info("Route to :" + uriBuilder.toUriString());
        return restTemplate.getForObject(uriBuilder.toUriString(), double.class);
    }

    @Override
    public Review createNewReview(Review review) {
        return null;
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
