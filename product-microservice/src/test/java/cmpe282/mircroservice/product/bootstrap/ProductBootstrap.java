package cmpe282.mircroservice.product.bootstrap;

import cmpe282.mircroservice.product.domain.Product;
import cmpe282.mircroservice.product.repositories.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
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

        Product product = buildProduct("A Book", "Book Description", "Book",
                                        10.0, 100);
        productRepository.save(product);

    }

    private static Product buildProduct(String name, String description, String category,
                                        Double price, Integer invetory) {
        return new Product(ObjectId.get(), name, description, category, price, invetory);
    }
}
