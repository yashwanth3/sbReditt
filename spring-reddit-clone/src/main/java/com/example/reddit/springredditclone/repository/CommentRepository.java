package com.example.reddit.springredditclone.repository;

import com.example.reddit.springredditclone.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
