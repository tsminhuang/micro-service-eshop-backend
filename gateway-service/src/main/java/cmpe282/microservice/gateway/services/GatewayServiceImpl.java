package cmpe282.microservice.gateway.services;

import cmpe282.microservice.gateway.domain.Product;
import java.util.List;
import java.util.Set;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@Slf4j
@Service
public class GatewayServiceImpl implements GatewayService {

    @Value("${rest.api.product}")
    private String PRODUCT_URL;
    private String CUSTOMER_URL;
    private String REVIEW_URL;

    private RestTemplate restTemplate = new RestTemplate();

    @Override
    public List<Product> findAllProducts() {
        log.info("Route to :" + PRODUCT_URL);
        ParameterizedTypeReference<List<Product>> params =
            new ParameterizedTypeReference<List<Product>>() {};
        ResponseEntity<List<Product>> response =
            restTemplate.exchange(PRODUCT_URL, HttpMethod.GET, null, params);

        return response.getBody();
    }

    @Override
    public Product getProductById(String id) {
        UriComponentsBuilder uriBuilder = createRestUri(PRODUCT_URL, id);
        log.info("Route to :" + uriBuilder.toUriString());

        return restTemplate.getForObject( uriBuilder.toUriString(), Product.class);
    }

    @Override
    public Set<Product> getProductByKeyword(String keyword) {
        UriComponentsBuilder uriBuilder = createRestUri(PRODUCT_URL + "/search", keyword);
        log.info("Route to :" + uriBuilder.toUriString());

        ParameterizedTypeReference<Set<Product>> params =
            new ParameterizedTypeReference<Set<Product>>() {};
        ResponseEntity<Set<Product>> response =
            restTemplate.exchange(uriBuilder.toUriString(), HttpMethod.GET, null, params);

        return response.getBody();
    }

    private UriComponentsBuilder createRestUri(String apiUri, String value) {
        return UriComponentsBuilder.fromUriString(apiUri).pathSegment(value);
    }
}
