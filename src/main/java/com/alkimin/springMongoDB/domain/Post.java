package com.alkimin.springMongoDB.domain;

import com.alkimin.springMongoDB.dto.AuthorDTO;
import com.alkimin.springMongoDB.dto.PostDTO;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@EqualsAndHashCode
@Document(collection="post")
public class Post {

    @Id
    private String id;
    private LocalDate date;
    private String title;
    private String body;
    private AuthorDTO author;

}
