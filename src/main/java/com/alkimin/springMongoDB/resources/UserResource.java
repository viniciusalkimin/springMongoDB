package com.alkimin.springMongoDB.resources;

import com.alkimin.springMongoDB.domain.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserResource {

    @GetMapping
    public ResponseEntity<List<User>> findAll() {
        User maria = new User("1","maria","maria@abc.com");
        User alex = new User("2","alex","alex@abc.com");
        var users = new ArrayList<User>(Arrays.asList(maria, alex));
        return ResponseEntity.ok().body(users);
    }

}
