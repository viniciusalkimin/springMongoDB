package com.alkimin.springMongoDB.dto;

import com.alkimin.springMongoDB.domain.Post;
import com.alkimin.springMongoDB.domain.User;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Getter
public class UserDTO implements Serializable {

    private String id;
    private String name;
    private String email;
    private List<Post> posts = new ArrayList<>();

    public UserDTO(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.email = user.getEmail();
        this.posts = user.getPosts();
    }

}
