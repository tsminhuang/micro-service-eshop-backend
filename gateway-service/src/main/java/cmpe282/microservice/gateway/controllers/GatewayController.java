package cmpe282.microservice.gateway.controllers;

import cmpe282.microservice.gateway.domain.Customer;
import cmpe282.microservice.gateway.domain.Product;
import cmpe282.microservice.gateway.domain.Review;
import cmpe282.microservice.gateway.services.GatewayService;
import java.util.List;
import java.util.Set;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(GatewayController.BASE_URL)
public class GatewayController {

    public static final String BASE_URL = "/gateway";

    private GatewayService gatewayService;

    public GatewayController(GatewayService gatewayService) {
        this.gatewayService = gatewayService;
    }

    // Product service route
    @GetMapping("/product")
    @ResponseStatus(HttpStatus.OK)
    public List<Product> getListOfProducts() {
        return gatewayService.findAllProducts();
    }

    @GetMapping("/product/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Product getProductById(@PathVariable String id) {
        return gatewayService.getProductById(id);
    }

    @GetMapping("/product/search/{keyword}")
    @ResponseStatus(HttpStatus.OK)
    public Set<Product> searchProductByKeyword(@PathVariable String keyword) {
        return gatewayService.getProductByKeyword(keyword);
    }

    // Customer service route
    @GetMapping("/customer")
    @ResponseStatus(HttpStatus.OK)
    public List<Customer> getListOfCustomers() {
        return gatewayService.findAllCustomers();
    }

    @PostMapping("/customer")
    @ResponseStatus(HttpStatus.CREATED)
    public Customer createNewCustomer(@RequestBody Customer customer) {
        return gatewayService.createNewCustomer(customer);
    }

    @PostMapping("/customer/auth")
    public ResponseEntity<HttpStatus> authenticateUser(@RequestBody Customer customer) {
        return gatewayService.authenticateUser(customer);
    }

    // Review service route
    @GetMapping("/review")
    @ResponseStatus(HttpStatus.OK)
    public List<Review> getListOfReviews() {
        return gatewayService.findAllReviews();
    }

    @GetMapping("/review/product/{productId}")
    public double getAvgReviewByProductId(@PathVariable String productId) {
        return gatewayService.getAvgReviewByProductId(productId);
    }


    @PostMapping("/review")
    @ResponseStatus(HttpStatus.CREATED)
    public Review createNewReview(@RequestBody Review review) {
        return gatewayService.createNewReview(review);
    }

}
