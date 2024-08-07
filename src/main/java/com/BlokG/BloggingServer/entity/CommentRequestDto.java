package com.BlokG.BloggingServer.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentRequestDto {
    private Long postId;
    private String postBy;
    private String content;
}
