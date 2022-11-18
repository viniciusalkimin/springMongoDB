package com.alkimin.springMongoDB.domain;

import com.alkimin.springMongoDB.dto.UserDTO;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Document(collection="user")
@Getter
public class User implements Serializable {

    @Id
    private String id;
    private String name;
    private String email;

    public User(UserDTO userDTO) {
        this.id = userDTO.getId();
        this.name = userDTO.getName();
        this.email = userDTO.getEmail();
    }
}
