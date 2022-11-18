package com.alkimin.springMongoDB.controller;

import com.alkimin.springMongoDB.domain.User;
import com.alkimin.springMongoDB.dto.UserDTO;
import com.alkimin.springMongoDB.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserResource {

    private UserService service;

    @GetMapping
    public ResponseEntity<List<UserDTO>> findAll() {
        return ResponseEntity.ok().body(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable String id) {
        var user = service.findById(id);
        return ResponseEntity.ok().body(new UserDTO(user));
    }

    @PostMapping
    public ResponseEntity<Void> insertUser(@RequestBody UserDTO userDto) {
        var userObj = service.insertUser(new User(userDto));
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                        .buildAndExpand(userObj.getId()).toUri();
       return ResponseEntity.created(uri).build();
    }

}
