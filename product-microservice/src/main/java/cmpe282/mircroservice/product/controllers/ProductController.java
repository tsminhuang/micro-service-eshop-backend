package cmpe282.mircroservice.product.controllers;

import cmpe282.mircroservice.product.domain.Product;
import cmpe282.mircroservice.product.services.ProductService;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
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

    @RequestMapping(value = "/list", method = RequestMethod.GET,
        produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Product> listAll() {
        log.debug("REST: listAll");
        return productService.listAll();
    }

    @RequestMapping(value = "/search/{pattern}", method = RequestMethod.GET,
        produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Product> search(@PathVariable String pattern) {
        log.debug("REST: search");
        return productService.search(pattern);
    }

}