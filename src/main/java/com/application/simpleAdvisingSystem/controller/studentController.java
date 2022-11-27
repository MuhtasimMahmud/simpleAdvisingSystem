package com.application.simpleAdvisingSystem.controller;

import com.application.simpleAdvisingSystem.helper.Message;
import com.application.simpleAdvisingSystem.models.slotRegisteredStudents;
import com.application.simpleAdvisingSystem.repositories.slotRegisteredStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
public class studentController {


    @Autowired
    slotRegisteredStudentRepository studentRepository;

    @GetMapping("/student")
    public String normalUser(){
        return "student/student";
    }

    @RequestMapping(value = "/book_slot", method  = RequestMethod.POST)
    public String bookSlot(@ModelAttribute("slotRegisteredStudent") slotRegisteredStudents student, Model model, HttpSession session){

        try{
            studentRepository.save(student);
            session.setAttribute("message", new Message("Successfully Registered your slot!", "alert-success"));

        }catch (Exception e){
            e.printStackTrace();
            session.setAttribute("message", new Message("something went wrong", "alert-danger"));
        }

        return "redirect:/student";
    }



}
