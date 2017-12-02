package cmpe282.microservice.product.controllers;

import cmpe282.microservice.product.domain.Product;
import cmpe282.microservice.product.services.ProductService;
import java.util.List;
import java.util.Set;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

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
    public Set<Product> getProductByKeyword(@PathVariable String keyword) {
        return productService.getProductByKeyword(keyword);
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