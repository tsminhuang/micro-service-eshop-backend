package cmpe282.mircroservice.product.controllers;

import cmpe282.mircroservice.product.domain.Product;
import cmpe282.mircroservice.product.services.ProductService;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    @RequestMapping("/list")
    List<Product> listAll() {
        return productService.listAll();
    }

}
