package com.BlokG.BloggingServer.service;

import com.BlokG.BloggingServer.entity.Comment;
import com.BlokG.BloggingServer.entity.Post;
import com.BlokG.BloggingServer.repository.CommentRepo;
import com.BlokG.BloggingServer.repository.PostRepo;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class CommentServiceImpl implements CommentService{

    @Autowired
    private CommentRepo commentRepo;
    @Autowired
    private PostRepo postRepo;

    public Comment createComment(Long postId,String postedBy,String content){
        Optional<Post> optionalPost = postRepo.findById(postId);
        if(optionalPost.isPresent()){
            Comment comment = new Comment();
            comment.setPost(optionalPost.get());
            comment.setContent(content);
            comment.setPostedBy(postedBy);
            comment.setCreatedAt(new Date());
            return commentRepo.save(comment);
        }
        throw new EntityNotFoundException("Post Not Found");
    }
}
