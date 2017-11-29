package cmpe282.microservice.product.controllers;

import cmpe282.microservice.product.domain.Product;
import cmpe282.microservice.product.services.ProductService;
import java.util.List;
import java.util.Set;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/product")
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    Product create(@RequestBody Product entry) {
        // TODO: Create Product
        return null;
    }

    @RequestMapping(value = "/delete/{Id}", method = RequestMethod.DELETE)
    Product delete(@PathVariable String Id) {
        // TODO: Delete Product
        return null;
    }

    @RequestMapping(value = "/update/{Id}", method = RequestMethod.PUT)
    public Product update(@RequestBody Product entry) {
        // TODO: update product
        return null;
    }

    @RequestMapping(value = "/list/{Id}", method = RequestMethod.GET)
    public Product findById(@PathVariable String Id) {
        return productService.findById(Id);
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<Product> findAll() {
        return productService.findAll();
    }

    @RequestMapping(value = "/search/{keyword}", method = RequestMethod.GET)
    public Set<Product> search(@PathVariable String keyword) {
        return productService.search(keyword);
    }

}