package cmpe282.microservice.product.services;

import cmpe282.microservice.product.domain.Product;
import java.util.List;
import java.util.Set;

public interface ProductService {

    List<Product> findAll();


    Product findById(String Id);

    Set<Product> search(String pattern);

    Product saveOrUpdate(Product product);
}
