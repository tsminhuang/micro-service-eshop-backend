package cmpe282.microservice.customer.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Document(collection = "customer")
public class Customer {

    @Id
    private String id;
    private String email;
    private String password;

    public Customer(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
