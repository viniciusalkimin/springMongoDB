package com.alkimin.springMongoDB.dto;

import com.alkimin.springMongoDB.domain.User;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class AuthorDTO {

    private String id;
    private String name;

    public AuthorDTO(User user) {
        this.id = user.getId();
        this.name = user.getName();
    }
}
