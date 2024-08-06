package com.BlokG.BloggingServer.service;

import com.BlokG.BloggingServer.entity.Comment;

public interface CommentService {
    Comment createComment(Long postId, String postedBy, String content);
}
