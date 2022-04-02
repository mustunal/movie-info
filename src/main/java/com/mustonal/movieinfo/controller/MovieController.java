package com.mustonal.movieinfo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/movie-info")
public class MovieController {

    @GetMapping
    public String sayHello(){
        return "Hello World";
    }
}
