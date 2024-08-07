package com.BlokG.BloggingServer.repository;

import com.BlokG.BloggingServer.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepo extends JpaRepository<Post,Long> {
    List<Post> findAllByNameContaining(String name);
}
