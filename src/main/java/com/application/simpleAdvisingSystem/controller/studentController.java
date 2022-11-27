package com.application.simpleAdvisingSystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class studentController {


    @GetMapping("/student")
    public String normalUser(){
        return "student/student";
    }

    @RequestMapping("/book_slot")
    public String bookSlot(){
        return "redirect: student/student";
    }



}
