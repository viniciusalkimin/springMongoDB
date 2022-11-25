package com.alkimin.springMongoDB.dto;

import com.alkimin.springMongoDB.domain.Post;
import com.alkimin.springMongoDB.domain.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PostDTO {

    private String id;
    private LocalDate date;
    private String title;
    private String body;
    private User author;

    public PostDTO(Post post) {
        this.id = post.getId();
        this.date = post.getDate();
        this.title = post.getTitle();
        this.body = post.getBody();
        this.author = post.getAuthor();
    }
}
