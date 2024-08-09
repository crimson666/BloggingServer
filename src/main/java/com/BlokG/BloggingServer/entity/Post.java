package com.BlokG.BloggingServer.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name="Post")
@AllArgsConstructor
@NoArgsConstructor
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    @Column(length = 5000)
    private String content;
    private String postBy;
    @Column(length = 5000)
    private String img;
    private Date date;
    private int likeCount;
    private int viewCount;
    private List<String> tag;
}
