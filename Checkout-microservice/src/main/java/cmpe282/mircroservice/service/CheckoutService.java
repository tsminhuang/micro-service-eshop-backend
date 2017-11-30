package cmpe282.mircroservice.service;

import cmpe282.mircroservice.model.Checkout;
import cmpe282.mircroservice.repository.CheckoutRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class CheckoutService {

    @Autowired
    CheckoutRepository checkoutRepository;

    public void createOrder(Checkout checkout){
        checkoutRepository.save(checkout);
    }
}
