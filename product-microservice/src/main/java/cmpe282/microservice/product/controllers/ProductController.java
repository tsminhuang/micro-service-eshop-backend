package cmpe282.microservice.product.controllers;

import cmpe282.microservice.product.domain.Product;
import cmpe282.microservice.product.services.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@Slf4j
@RestController
@RequestMapping(ProductController.BASE_URL)
public class ProductController {

    public static final String BASE_URL = "/api/product";

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Product> getListOfProducts() {
        return productService.findAllProducts();
    }

    @GetMapping({"/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public Product getProductById(@PathVariable String id) {
        return productService.getProductById(id);
    }

    @GetMapping({"/search/{keyword}"})
    @ResponseStatus(HttpStatus.OK)
    public Set<Product> search(@PathVariable String keyword) {
        return productService.search(keyword);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Product createNewProduct(@RequestBody Product product) {
        return productService.createNewProduct(product);
    }

    @DeleteMapping({"/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public void deleteProductWithId(@PathVariable String id) {
        productService.deleteProductWithId(id);
    }


    @PutMapping({"/order/{id}/{unit}"})
    @ResponseStatus(HttpStatus.OK)
    public boolean orderProductById(@PathVariable String id, @PathVariable int unit) {
        return productService.orderProductById(id, unit);
    }

}