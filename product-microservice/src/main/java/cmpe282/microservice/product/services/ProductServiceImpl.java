package cmpe282.microservice.product.services;

import cmpe282.microservice.product.domain.Product;
import cmpe282.microservice.product.repositories.ProductRepository;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product saveOrUpdate(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Set<Product> search(String keyword) {
        List<Product> products = productRepository.findByKeyword(keyword);
        Set<Product> set = new HashSet<>(products);
        return set;
    }

    @Override
    public Product findById(String Id) {
        Optional<Product> products = productRepository.findById(Id);

        if (!products.isPresent()) {
            log.debug("Not found");
            return null;
        }

        return products.get();
    }
}
