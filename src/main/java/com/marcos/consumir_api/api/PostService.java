package com.marcos.consumir_api.api;

import com.marcos.consumir_api.dto.Post;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

@Service
public class PostService {

    private final WebClient webClient;

    public PostService(WebClient webClient) {
        this.webClient = webClient;
    }

    public Flux<Post> getPosts(){
        return webClient
                .get()
                .uri("/posts")
                .retrieve()
                .bodyToFlux(Post.class);
    }
}
