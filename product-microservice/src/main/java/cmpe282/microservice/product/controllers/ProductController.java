package cmpe282.microservice.product.controllers;

import cmpe282.microservice.product.domain.Product;
import cmpe282.microservice.product.services.ProductService;
import java.util.List;
import java.util.Set;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/product")
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping(method = RequestMethod.POST)
    public Product addProduct(@RequestBody Product product) {
        return productService.addProduct(product);
    }

    @RequestMapping(value = "/{Id}", method = RequestMethod.DELETE)
    public void deleteProductWithId(@PathVariable String Id) {
        productService.deleteProductWithId(Id);
    }

    @RequestMapping(value = "/{Id}", method = RequestMethod.GET)
    public Product findProductById(@PathVariable String Id) {
        return productService.findProductById(Id);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<Product> findAll() {
        return productService.findAllProducts();
    }

    @RequestMapping(value = "/search/{keyword}", method = RequestMethod.GET)
    public Set<Product> search(@PathVariable String keyword) {
        return productService.search(keyword);
    }

    @RequestMapping(value = "/order/{productId}/{unit}", method = RequestMethod.PUT)
    public boolean orderProductById(@PathVariable String productId, @PathVariable int unit) {
        return productService.orderProductById(productId, unit);
    }

}