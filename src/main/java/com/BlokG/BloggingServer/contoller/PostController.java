package com.BlokG.BloggingServer.contoller;

import com.BlokG.BloggingServer.entity.Post;
import com.BlokG.BloggingServer.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/posts")
@CrossOrigin(origins = "*")
public class PostController {
    @Autowired
    private PostService postService;

    @PostMapping
    public ResponseEntity<?> createPost(@RequestBody Post post){
        try {
            Post createPostData = postService.savePost(post);
            return ResponseEntity.status(HttpStatus.CREATED).body(createPostData);
        }catch (Exception ex){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
