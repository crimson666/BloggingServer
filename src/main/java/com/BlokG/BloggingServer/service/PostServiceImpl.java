package com.BlokG.BloggingServer.service;

import com.BlokG.BloggingServer.entity.Post;
import com.BlokG.BloggingServer.repository.PostRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class PostServiceImpl implements PostService{

    @Autowired
    private PostRepo postRepo;

    public Post savePost(Post post){
        post.setLikeCount(0);
        post.setVoteCount(0);
        post.setDate(new Date());
        return postRepo.save(post);
    }
}
