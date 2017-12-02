package cmpe282.microservice.customer.controllers;

import cmpe282.microservice.customer.domain.Customer;
import cmpe282.microservice.customer.services.CustomerService;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(CustomerController.BASE_URL)
public class CustomerController {

    public static final String BASE_URL = "/api/customer";

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Customer> getListOfCustomers() {
        return customerService.findAllCustomers();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Customer createNewCustomer(@RequestBody Customer customer) {
        return customerService.createNewCustomer(customer);
    }

    @PostMapping({"/auth"})
    public ResponseEntity<HttpStatus> authenticateUser(@RequestBody Customer customer) {
        if (customerService.authenticateCustomer(customer)) {
            return new ResponseEntity<>(HttpStatus.OK);
        }

        return new ResponseEntity<HttpStatus>(HttpStatus.UNAUTHORIZED);
    }
}
