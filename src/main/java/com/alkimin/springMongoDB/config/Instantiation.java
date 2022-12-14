package com.alkimin.springMongoDB.config;

import com.alkimin.springMongoDB.domain.CommentDTO;
import com.alkimin.springMongoDB.domain.Post;
import com.alkimin.springMongoDB.domain.User;
import com.alkimin.springMongoDB.dto.AuthorDTO;
import com.alkimin.springMongoDB.repository.PostRepository;
import com.alkimin.springMongoDB.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@AllArgsConstructor
@Configuration
public class Instantiation implements CommandLineRunner {

    private UserRepository userRepository;

    private PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {

        userRepository.deleteAll();
        postRepository.deleteAll();

        User vinicius = new User(null, "Vinicius Alkimin", "viniciusalkimin@gmail.com");
        User davi = new User(null, "Davi Alkimin", "dalkimin@gmail.com");
        User nelio = new User(null, "Nelio Alves", "acnelio@gmail.com");

        userRepository.saveAll(Arrays.asList(vinicius,davi,nelio));

        Post post1 = new Post(null, LocalDate.of(2022, 11, 20), "Partiu viagem", "Vou viajar para MG, abraços!", new AuthorDTO(vinicius));
        Post post2 = new Post(null, LocalDate.now(),"Chegando ao destino", "Lugar maravilhoso, obrigado Deus!", new AuthorDTO(vinicius));

        CommentDTO c1 = new CommentDTO("Boa viagem mano!", LocalDate.of(2022, 11, 20), new AuthorDTO(davi));
        CommentDTO c2 = new CommentDTO("Aproveite", LocalDate.of(2022, 11, 20), new AuthorDTO(davi));
        CommentDTO c3 = new CommentDTO("Tenha um ótimo dia!", LocalDate.of(2022, 11, 25), new AuthorDTO(nelio));

        post1.getComments().addAll(Arrays.asList(c1, c2));
        post2.getComments().addAll(List.of(c3));


        vinicius.getPosts().addAll(Arrays.asList(post1,post2));
        postRepository.saveAll(Arrays.asList(post1,post2));
        userRepository.save(vinicius);


    }
}
