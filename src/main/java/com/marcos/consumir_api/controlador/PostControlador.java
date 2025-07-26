package com.marcos.consumir_api.controlador;

import com.marcos.consumir_api.api.PostService;
import com.marcos.consumir_api.dto.Post;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/post-mostrar")
public class PostControlador {

    private final PostService postService;

    public PostControlador(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/posts")
    public ResponseEntity<Flux<Post>> listarPosts(){
        return ResponseEntity.ok(postService.getPosts());
    }
}
