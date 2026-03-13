package com.yubi.API1.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String sayHello(){
        return "Welcome to my REST API";
    }

    @GetMapping("/about")
    public String sayAbout(){
        return "Welcome to my REST API. Developed by Tariq";
    }

}
