package com.example.reddit.springredditclone.model;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import jakarta.websocket.OnMessage;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.NotBlank;

import java.time.Instant;


@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postId;
    @NotBlank(message="POst cannot be empty")
    private  String postName;
    @Nullable
    private String url;
    @Nullable
    @Lob
    private String description;
    private Integer voteCount;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name= "userId", referencedColumnName = "userId")
    private  User user;
    private Instant createdDate;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name= "id", referencedColumnName = "id")
    private  Subreddit subreddit;



}
