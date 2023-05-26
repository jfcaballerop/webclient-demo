package com.mrknight.webclients.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import com.mrknight.webclients.model.Post;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

@Slf4j
@RestController
public class WebController {

  private static final int DEFAULT_PORT = 8080;

  @Setter
  private int serverPort = DEFAULT_PORT;

  @GetMapping(value = "/posts-non-blocking", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
  public Flux<Post> getPostsNonBlocking() {
    log.info("Starting NON-BLOCKING controller!");

    Flux<Post> postFlux = WebClient.create()
        .get()
        .uri(this.getSlowServiceUri())
        .retrieve()
        .bodyToFlux(Post.class);

    postFlux.subscribe(post -> log.info(post.toString()));

    log.info("Saliendo del controller!");
    return postFlux;

  }

  private String getSlowServiceUri() {
    // "https://my-json-server.typicode.com/jfcaballerop/fantasy-demo/posts"
    return "http://localhost:" + serverPort + "/delay-controller";
  }
}
