package com.example.reddit.springredditclone.repository;

import com.example.reddit.springredditclone.model.Vote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VoteRepository  extends JpaRepository<Vote, Long> {
}
