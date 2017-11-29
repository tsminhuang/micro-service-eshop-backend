package cmpe282.mircroservice.repository;

import cmpe282.mircroservice.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface IUserRepository extends MongoRepository<User, String> {


}
