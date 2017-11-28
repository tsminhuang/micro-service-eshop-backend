package cmpe282.mircoservice.review.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "review")
public class Review {

    @Id
    private ObjectId id;
    private ObjectId customerId;
    private ObjectId productId;
    private Integer rating;
    private String review;
}
