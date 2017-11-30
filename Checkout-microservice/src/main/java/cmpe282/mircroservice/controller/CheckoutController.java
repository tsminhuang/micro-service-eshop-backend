package cmpe282.mircroservice.controller;


import cmpe282.mircroservice.model.Checkout;
import cmpe282.mircroservice.service.CheckoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/checkout")
public class CheckoutController {

    @Autowired
    CheckoutService checkoutService;

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ResponseEntity<Checkout> create (@RequestBody Checkout checkout){
        checkoutService.createOrder(checkout);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
