package cmpe282.microservice.webui.controllers;

import cmpe282.microservice.webui.domain.Customer;
import cmpe282.microservice.webui.domain.Product;
import cmpe282.microservice.webui.servies.WebService;
import java.util.List;
import java.util.Set;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import sun.rmi.runtime.Log;

@Slf4j
@Controller
@RequestMapping(WebController.BASE_URL)
public class WebController {

    public static final String BASE_URL = "/webui";

    private WebService webService;

    public WebController(WebService webService) {
        this.webService = webService;
    }

    @GetMapping("/product")
    public String getListOfProducts(Model model) {
        List<Product> products = webService.findAllProducts();
        model.addAttribute("products", products);

        return "product/list";
    }

    @GetMapping("/product/{id}")
    public String getProductById(@PathVariable String id, Model model) {
        Product product = webService.getProductById(id);
        model.addAttribute("product", product);

        double review = webService.getAvgReviewByProductId(id);
        model.addAttribute("review", review);

        return "product/show";
    }

    //@GetMapping("/product/search/")
    @RequestMapping(value = "/product/search", method = RequestMethod.GET)
    public String searchProductByKeyword(@RequestParam String keyword, Model model) {

        if(keyword.isEmpty()) {
            List<Product> products = webService.findAllProducts();
            model.addAttribute("products", products);
        } else {
            Set<Product> products = webService.getProductByKeyword(keyword);
            model.addAttribute("products", products);
        }


        return "product/list";
    }

    @GetMapping("/customer/login")
    public String authenticateUser(Model model) {
        model.addAttribute("customer", new Customer());

        return "customer/login";
    }

    @PostMapping("/customer/login")
    public String authenticateUser(Model model, @ModelAttribute("customer") Customer customer) {
        boolean isAuth =  webService.authenticateUser(customer);
        model.addAttribute("isAuth", isAuth);
        return "customer/status";
    }


}
