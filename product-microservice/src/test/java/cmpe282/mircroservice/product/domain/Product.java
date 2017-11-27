package cmpe282.mircroservice.product.domain;

import java.math.BigDecimal;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "product")
@NoArgsConstructor
public class Product {

    @Id
    private ObjectId Id;
    private String name;
    private String description;
    private String category;
    private BigDecimal price;
    private Integer inventory;
}
