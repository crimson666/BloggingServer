package com.BlokG.BloggingServer.service;

import com.BlokG.BloggingServer.entity.Post;

import java.util.List;

public interface PostService {
    Post savePost(Post post);
    List<Post> getAllPosts();
    Post getPostById(Long postId);
    public void likePost(Long postId);
    public List<Post> findPostByName(String name);
}
