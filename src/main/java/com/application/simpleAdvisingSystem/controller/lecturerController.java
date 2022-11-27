package com.application.simpleAdvisingSystem.controller;


import com.application.simpleAdvisingSystem.models.slotRegisteredStudents;
import com.application.simpleAdvisingSystem.repositories.slotRegisteredStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class lecturerController {


    @Autowired
    slotRegisteredStudentRepository studentRepository;

    @GetMapping("/lecturer")
    public String adminUser(Model model){

        List<slotRegisteredStudents> students = studentRepository.findAll();
        model.addAttribute("students", students);

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
