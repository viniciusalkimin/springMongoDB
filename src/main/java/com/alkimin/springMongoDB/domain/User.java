package com.alkimin.springMongoDB.domain;

import lombok.*;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Getter
public class User implements Serializable {

    private String id;
    private String name;
    private String email;
}
