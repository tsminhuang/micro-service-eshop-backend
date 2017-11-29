package cmpe282.microservice.product.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "product")
public class Product {

    @Id
    private String id;
    private String name;
    private String description;
    private String category;
    private Double price;
    private Integer stocks;
    private String email;

    public Product(String name, String description, String category,
        Double price, Integer stocks) {
        this.name = name;
        this.description = description;
        this.category = category;
        this.price = price;
        this.stocks = stocks;
    }
}
