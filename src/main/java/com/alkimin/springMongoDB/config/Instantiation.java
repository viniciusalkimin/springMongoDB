package com.alkimin.springMongoDB.config;

import com.alkimin.springMongoDB.domain.User;
import com.alkimin.springMongoDB.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@AllArgsConstructor
@Configuration
public class Instantiation implements CommandLineRunner {

    private UserRepository repository;

    @Override
    public void run(String... args) throws Exception {
        User vinicius = new User(null, "Vinicius Alkimin", "viniciusalkimin@gmail.com");
        User davi = new User(null, "Davi Alkimin", "dalkimin@gmail.com");
        User nelio = new User(null, "Nelio Alves", "acnelio@gmail.com");
        repository.deleteAll();
        repository.saveAll(Arrays.asList(vinicius,davi,nelio));
    }
}
