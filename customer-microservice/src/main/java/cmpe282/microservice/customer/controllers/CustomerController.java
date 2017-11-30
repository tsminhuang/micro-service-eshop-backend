package cmpe282.microservice.customer.controllers;

import cmpe282.microservice.customer.domain.Customer;
import cmpe282.microservice.customer.services.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(CustomerController.BASE_URL)
public class CustomerController {
    public static final String BASE_URL = "/api/customer";

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
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
