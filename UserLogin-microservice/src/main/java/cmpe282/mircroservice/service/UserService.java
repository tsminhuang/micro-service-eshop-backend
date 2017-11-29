package cmpe282.mircroservice.service;

import cmpe282.mircroservice.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import cmpe282.mircroservice.repository.IUserRepository;
import org.springframework.util.StringUtils;

public class UserService {

    @Autowired
    private IUserRepository iUserRepository;

    public void createUser(User user) {
        iUserRepository.save(user);
    }

    public boolean authenticateUser(User user) {
        boolean isAuthenticated = false;
        if (user != null) {
            if (!StringUtils.isEmpty(user.getEmail())
                    && !StringUtils.isEmpty(user.getPassword())) {
                User dbuser = iUserRepository.findOne(user.getId());

                if (dbuser != null && user.getPassword().equals(dbuser.getPassword())) {
                    isAuthenticated = true;
                }
            }
        }
        return isAuthenticated;
    }
}