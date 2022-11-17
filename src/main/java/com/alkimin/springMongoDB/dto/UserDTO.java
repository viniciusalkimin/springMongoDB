package com.alkimin.springMongoDB.dto;

import com.alkimin.springMongoDB.domain.User;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;
import java.util.Optional;

@AllArgsConstructor
@Getter
public class UserDTO implements Serializable {

    private String id;
    private String name;
    private String email;

    public UserDTO(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.email = user.getEmail();
    }

}
