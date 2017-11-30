package cmpe282.microservice.product.bootstrap;

import cmpe282.microservice.product.domain.Product;
import cmpe282.microservice.product.repositories.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ProductBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private final ProductRepository productRepository;

    public ProductBootstrap(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        loadProducts();
    }

    private void loadProducts() {
        productRepository.deleteAll();
        buildProduct("A Book1", "Book Description", "Book",
                20.0, 10);
        buildProduct("A Book2", "Book Description", "Book",
                6941.0, 99);
        buildProduct("A Disc", "Disc Description", "Disc",
                20.0, 10);
        buildProduct("A PC", "PC Description", "PC",
                6941.0, 99);

    }

    private void buildProduct(String name, String description, String category,
                              Double price, Integer inventory) {
        final Product product = new Product(name, description, category, price, inventory);
        productRepository.save(product);
    }
}
