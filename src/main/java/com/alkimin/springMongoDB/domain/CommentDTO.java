package com.alkimin.springMongoDB.domain;

import com.alkimin.springMongoDB.dto.AuthorDTO;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data@AllArgsConstructor
public class CommentDTO {

    private String text;
    private LocalDate date;
    private AuthorDTO author;
}
