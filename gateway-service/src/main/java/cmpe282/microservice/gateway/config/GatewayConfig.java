package cmpe282.microservice.gateway.config;

import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

    // TODO: put other micro service URL
    public String CUSTOMER_SERVICE_URL;

    public String PRODUCT_SERVICE_BASE_URL;

    public String REIVE_SERVICE_BASE_URL;

}
