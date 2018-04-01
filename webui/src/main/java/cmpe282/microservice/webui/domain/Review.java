package cmpe282.microservice.webui.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Review {

    private String id;
    private String productId;
    private String customerId;
    private Double rating;
}
