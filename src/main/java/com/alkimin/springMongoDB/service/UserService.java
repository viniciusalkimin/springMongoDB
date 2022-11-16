package com.alkimin.springMongoDB.service;

import com.alkimin.springMongoDB.domain.User;
import com.alkimin.springMongoDB.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService {

    private UserRepository repository;

    public List<User> findAll (){
        return repository.findAll();
    }

    public User getOne(String name) {
        return repository.findByName(name);
    }
}
