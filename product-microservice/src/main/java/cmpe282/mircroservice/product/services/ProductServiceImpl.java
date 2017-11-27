package cmpe282.mircroservice.product.services;

import cmpe282.mircroservice.product.domain.Product;
import cmpe282.mircroservice.product.repositories.ProductRepository;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepository repo;

    @Autowired
    public ProductServiceImpl(ProductRepository repo) {
        this.repo = repo;
    }

    @Override
    public List<Product> listAll() {
        return repo.findAll();
    }

    @Override
    public Product saveOrUpdate(Product product) {
        return repo.save(product);
    }

    @Override
    public List<Product> search(String pattern) {
        // TODO: serach service
        return null;
    }
}
