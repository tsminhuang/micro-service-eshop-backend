package cmpe282.mircroservice.model;


import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "checkout")
public class Checkout {
    private String Id;
    private Integer number;

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }
}
