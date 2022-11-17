package com.alkimin.springMongoDB.service;

import com.alkimin.springMongoDB.domain.User;
import com.alkimin.springMongoDB.dto.UserDTO;
import com.alkimin.springMongoDB.repository.UserRepository;
import com.alkimin.springMongoDB.service.exception.ObjectNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserService {

    private UserRepository repository;

    public List<UserDTO> findAll (){
        List<User> userList = repository.findAll();
        return userList.stream().map(user -> new UserDTO(user)).collect(Collectors.toList());
    }

    public User findById(String id) {
      var user = repository.findById(id);
      return user.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

    public User getOne(String name) {
        return repository.findByName(name);
    }
}
