package com.alkimin.springMongoDB.service;

import com.alkimin.springMongoDB.domain.Post;
import com.alkimin.springMongoDB.domain.User;
import com.alkimin.springMongoDB.dto.PostDTO;
import com.alkimin.springMongoDB.dto.UserDTO;
import com.alkimin.springMongoDB.repository.PostRepository;
import com.alkimin.springMongoDB.service.exception.ObjectNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class PostService {

    private PostRepository repository;

    public List<PostDTO> findAll() {
        List<Post> postList= repository.findAll();
        return postList.stream().map(PostDTO::new).collect(Collectors.toList());
    }

    public Post getPostById(String id) {
        Optional<Post> post = repository.findById(id);
        return post.orElseThrow(() -> new ObjectNotFoundException("Object not found!"));
    }
}
