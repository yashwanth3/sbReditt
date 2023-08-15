package com.example.reddit.springredditclone.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class Hello {
    @GetMapping("/hi")
    public String hi(){
        return "hi spring reddit";
    }

    @GetMapping("/api/auth/hello")
    public String hello(){
        return "hello spring reddit";
    }
}
