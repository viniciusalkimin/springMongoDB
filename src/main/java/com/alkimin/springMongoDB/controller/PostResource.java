package com.alkimin.springMongoDB.controller;

import com.alkimin.springMongoDB.domain.Post;
import com.alkimin.springMongoDB.dto.PostDTO;
import com.alkimin.springMongoDB.service.PostService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/posts")
@AllArgsConstructor
public class PostResource {

    private PostService service;

    @GetMapping
    public ResponseEntity<List<PostDTO>> findAll() {
        return ResponseEntity.ok().body(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PostDTO> findById(@PathVariable String id) {
        var post = service.getPostById(id);
        return ResponseEntity.ok().body(new PostDTO(post));
    }
}
