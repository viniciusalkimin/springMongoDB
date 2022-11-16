package com.alkimin.springMongoDB.config;

import com.alkimin.springMongoDB.domain.User;
import com.alkimin.springMongoDB.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@AllArgsConstructor
@Configuration
public class Instantiation implements CommandLineRunner {

    private UserRepository repository;

    @Override
    public void run(String... args) throws Exception {
        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User bob = new User(null, "Bob Grey", "bob@gmail.com");
        repository.deleteAll();
        repository.saveAll(Arrays.asList(alex,maria,bob));
    }
}
