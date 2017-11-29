package cmpe282.microservice.review.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "review")
public class Review {

    @Id
    private String id;
    private String productId;
    private String customerId;
    private Double rating;

    public Review(String productId, String customerId, Double rating) {
        this.productId = productId;
        this.customerId = customerId;
        this.rating = rating;
    }
}
