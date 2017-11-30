package cmpe282.microservice.gateway.controllers;

import cmpe282.microservice.gateway.services.GatewayService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(GatewayController.BASE_URL)
public class GatewayController {

    public static final String BASE_URL = "/gateway";

    private GatewayService gatewayService;

    public GatewayController(GatewayService gatewayService) {
        this.gatewayService = gatewayService;
    }

    // TODO: add route service
}
