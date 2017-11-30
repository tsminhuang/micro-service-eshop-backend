package cmpe282.mircroservice.controller;


import cmpe282.mircroservice.model.User;
import cmpe282.mircroservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userservice;

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ResponseEntity<User> create (@RequestBody User user){
        userservice.createUser(user);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @RequestMapping(value = "/auth", method = RequestMethod.POST)
    public ResponseEntity<HttpStatus> authenticateUser (@RequestBody User user){
        if(userservice.authenticateUser(user))
            return new ResponseEntity<HttpStatus>(HttpStatus.OK);
        else
            return new ResponseEntity<HttpStatus>(HttpStatus.UNAUTHORIZED);
    }



}
