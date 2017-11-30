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
    public Product createNewProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public void deleteProductWithId(String id) {
        productRepository.deleteById(id);
    }

    @Override
    public Product getProductById(String id) {
        Optional<Product> product = productRepository.findById(id);
        if (!product.isPresent()) {
            throw new ResourceNotFoundException("Product id: " + id + " not found");
        }

        return product.get();
    }

    @Override
    public List<Product> findAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Set<Product> search(String keyword) {
        List<Product> products = productRepository.findByKeyword(keyword);

        return new HashSet<>(products);
    }

    @Override
    public boolean orderProductById(String id, int orderUnit) {

        Product orderProduct = getProductById(id);
        int stocks = orderProduct.getStocks();
        if (stocks < orderUnit) {
            return false;
        }
        orderProduct.setStocks(stocks - orderUnit);
        productRepository.save(orderProduct);

        return true;
    }


}
