package cmpe282.microservice.product.services;

import cmpe282.microservice.product.domain.Product;

import java.util.List;
import java.util.Set;

public interface ProductService {

    Product createNewProduct(Product product);

    void deleteProductWithId(String id);

    Product getProductById(String id);

    List<Product> findAllProducts();

    Set<Product> search(String pattern);

    boolean orderProductById(String id, int unit);

}
