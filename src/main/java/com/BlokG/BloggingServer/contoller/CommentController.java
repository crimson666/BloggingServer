package com.BlokG.BloggingServer.contoller;

import com.BlokG.BloggingServer.entity.Comment;
import com.BlokG.BloggingServer.entity.CommentRequestDto;
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

    @PostMapping("/create")
    private ResponseEntity<?> createComment(@RequestBody CommentRequestDto commentRequest){
        try{
            return ResponseEntity.ok(commentService.createComment(commentRequest.getPostId(),commentRequest.getPostBy(),commentRequest.getContent()));
        }catch (Exception ex){
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(ex.getMessage());
        }
    }

    @GetMapping("/{postId}")
    private ResponseEntity<?> getCommentsByPostId(@PathVariable Long postId){
        try{
            return ResponseEntity.ok(commentService.getCommentsByPostId(postId));
        }catch (Exception ex){
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(ex.getMessage());
        }
    }
}
