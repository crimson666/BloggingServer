package com.BlokG.BloggingServer.repository;

import com.BlokG.BloggingServer.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepo extends JpaRepository<Comment,Long> {
}
