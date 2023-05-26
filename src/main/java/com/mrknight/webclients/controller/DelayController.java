package com.mrknight.webclients.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mrknight.webclients.model.Post;

@RestController
public class DelayController {

  @GetMapping("/delay-controller")
  private List<Post> getAllPostsWithDelay() throws Exception {
    Thread.sleep(2000L);

    return Arrays.asList(
        new Post(1, "Slow Post 1"),
        new Post(2, "Slow Post 2"),
        new Post(3, "Slow Post 3"));
  }

}
