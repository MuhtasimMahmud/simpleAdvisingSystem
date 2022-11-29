package com.application.simpleAdvisingSystem.controller;


import com.application.simpleAdvisingSystem.helper.Message;
import com.application.simpleAdvisingSystem.models.slot;
import com.application.simpleAdvisingSystem.models.slotRegisteredStudents;
import com.application.simpleAdvisingSystem.repositories.slotRegisteredStudentRepository;
import com.application.simpleAdvisingSystem.repositories.slotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class lecturerController {


    @Autowired
    slotRegisteredStudentRepository studentRepository;

    @Autowired
    slotRepository slotRepository;

    @GetMapping("/lecturer")
    public String adminUser(Model model){

        List<slotRegisteredStudents> students = studentRepository.findAll();
        model.addAttribute("students", students);

        return "lecturer/lecturer";
    }

    @RequestMapping("/create_slot")
    public String createSlot(@ModelAttribute("newSlot") slot slot, Model model, HttpSession session){

        try{

            slot existedSlot = slotRepository.findBySlotID(slot.getSlotID());

            if(existedSlot == null){
                slotRepository.save(slot);
                session.setAttribute("message", new Message("new slot created!", "alert-success"));
            }else{
                session.setAttribute("message", new Message("Sorry, already there are a slot by this id. Choose another slotID!!", "alert-danger"));
            }

        }catch (Exception e){
            e.printStackTrace();
            session.setAttribute("message", new Message("Something went wrong !!" + e.getMessage(), "alert-danger"));
        }

        return "redirect:/lecturer";
    }

}
