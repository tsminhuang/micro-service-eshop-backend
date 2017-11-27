package cmpe282.mircroservice.product.services;

import cmpe282.mircroservice.product.domain.Product;
import java.util.List;

public interface ProductService {

    List<Product> listAll();

    Product saveOrUpdate(Product product);
}
