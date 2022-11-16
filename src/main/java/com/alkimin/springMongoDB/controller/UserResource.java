package com.alkimin.springMongoDB.controller;

import com.alkimin.springMongoDB.domain.User;
import com.alkimin.springMongoDB.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserResource {

    private UserService service;

    @GetMapping
    public ResponseEntity<List<User>> findAll() {
        return ResponseEntity.ok().body(service.findAll());
    }

    @GetMapping("/{name}")
    public ResponseEntity<User> getOne(@PathVariable String name) {
        return ResponseEntity.ok().body(service.getOne(name));
    }

}
