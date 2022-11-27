package com.application.simpleAdvisingSystem.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class lecturerController {


    @GetMapping("/lecturer")
    public String adminUser(){
        return "lecturer/lecturer";
    }



//    @RequestMapping("/admin")
//    public String adminView(Model model){
//
//        List<User> user = patientRepository.findAll();
//        model.addAttribute("patients", patients);
//        return "admin/admin";
//    }


}
