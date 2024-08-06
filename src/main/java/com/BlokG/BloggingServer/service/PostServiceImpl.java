package com.BlokG.BloggingServer.service;

import com.BlokG.BloggingServer.entity.Post;
import com.BlokG.BloggingServer.repository.PostRepo;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PostServiceImpl implements PostService{

    @Autowired
    private PostRepo postRepo;

    public Post savePost(Post post){
        post.setLikeCount(0);
        post.setViewCount(0);
        post.setDate(new Date());
        return postRepo.save(post);
    }

    public List<Post> getAllPosts(){
        return postRepo.findAll();
    }

    public Post getPostById(Long postId){
        Optional<Post> optionalPost = postRepo.findById(postId);
        if(optionalPost.isPresent()){
            Post post = optionalPost.get();
            post.setViewCount(post.getViewCount() + 1);
            return postRepo.save(post);
        }else{
            throw new EntityNotFoundException(":/ Post not found");
        }
    }
}
