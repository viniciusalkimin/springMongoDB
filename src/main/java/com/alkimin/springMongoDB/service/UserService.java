package com.alkimin.springMongoDB.service;

import com.alkimin.springMongoDB.domain.User;
import com.alkimin.springMongoDB.dto.UserDTO;
import com.alkimin.springMongoDB.repository.UserRepository;
import com.alkimin.springMongoDB.service.exception.ObjectNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserService {

    private UserRepository repository;

    public List<UserDTO> findAll (){
        List<User> userList = repository.findAll();
        return userList.stream().map(UserDTO::new).collect(Collectors.toList());
    }

    public User findById(String id) {
      var user = repository.findById(id);
      return user.orElseThrow(() -> new ObjectNotFoundException("Object not found!"));
    }

    public User insertUser(User user) {
       return repository.insert(user);
    }

    public void deleteUser(String id) {
        Optional<User> userForDelete = repository.findById(id);
        if(userForDelete.isEmpty()){
            throw new ObjectNotFoundException("Object not found!");
        }
        repository.deleteById(id);
    }

    public User getOne(String name) {
        return repository.findByName(name);
    }
}
