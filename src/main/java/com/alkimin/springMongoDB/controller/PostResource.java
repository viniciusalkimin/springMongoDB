package com.alkimin.springMongoDB.controller;

import com.alkimin.springMongoDB.controller.util.URL;
import com.alkimin.springMongoDB.domain.Post;
import com.alkimin.springMongoDB.dto.PostDTO;
import com.alkimin.springMongoDB.service.PostService;
import lombok.AllArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/titlesearch")
    public ResponseEntity<List<Post>> findByTitle(@RequestParam(value = "text", defaultValue = "") String text) {
        text = URL.decodeParam(text);
        List<Post> list = service.findByTitle(text);
        return ResponseEntity.ok().body(list);
    }
}
