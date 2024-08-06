package com.BlokG.BloggingServer.contoller;

import com.BlokG.BloggingServer.entity.Comment;
import com.BlokG.BloggingServer.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/comments")
@CrossOrigin
public class CommentController {
    @Autowired
    private CommentService commentService;

    @PostMapping
    private ResponseEntity<?> createComment(@RequestParam Long postId,
                                                  @RequestParam String postBy,
                                                  @RequestParam String content){
        try{
            return ResponseEntity.ok(commentService.createComment(postId,postBy,content));
        }catch (Exception ex){
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(ex.getMessage());
        }
    }
}
