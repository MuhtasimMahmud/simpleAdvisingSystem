package com.application.simpleAdvisingSystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class userController {


    @GetMapping("/student")
    public String normalUser(){
        return "student/student";
    }

    @GetMapping("/lecturer")
    public String adminUser(){
        return "lecturer/lecturer";
    }

}
