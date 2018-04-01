package cmpe282.microservice.gateway.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
@PropertySource("classpath:application.properties")
public class GatewayConfig {

    @Value("${rest.api.product}")
    private String PRODUCT_URL;
    @Value("${rest.api.customer}")
    private String CUSTOMER_URL;
    @Value("${rest.api.review}")
    private String REVIEW_URL;

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

}
