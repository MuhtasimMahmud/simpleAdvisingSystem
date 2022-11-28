package com.application.simpleAdvisingSystem.controller;

import com.application.simpleAdvisingSystem.helper.Message;
import com.application.simpleAdvisingSystem.models.slot;
import com.application.simpleAdvisingSystem.models.slotRegisteredStudents;
import com.application.simpleAdvisingSystem.repositories.slotRegisteredStudentRepository;
import com.application.simpleAdvisingSystem.repositories.slotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class studentController {


    @Autowired
    slotRegisteredStudentRepository studentRepository;

    @Autowired
    slotRepository slotRepository;

    @GetMapping("/student")
    public String normalUser(Model model){

        List<slot> slots = slotRepository.findAll();
        model.addAttribute("slots", slots);
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
