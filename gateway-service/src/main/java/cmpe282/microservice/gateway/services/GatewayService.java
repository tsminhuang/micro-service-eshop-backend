package cmpe282.microservice.gateway.services;

import cmpe282.microservice.gateway.domain.Product;
import java.util.List;
import java.util.Set;

public interface GatewayService {

    List<Product> findAllProducts();

    Product getProductById(String id);

    Set<Product> getProductByKeyword(String keyword);
}
