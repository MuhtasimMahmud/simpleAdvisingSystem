package com.application.simpleAdvisingSystem.controller;

import com.application.simpleAdvisingSystem.helper.Message;
import com.application.simpleAdvisingSystem.models.User;
import com.application.simpleAdvisingSystem.models.slot;
import com.application.simpleAdvisingSystem.models.slotRegisteredStudents;
import com.application.simpleAdvisingSystem.repositories.UserRepository;
import com.application.simpleAdvisingSystem.repositories.slotRegisteredStudentRepository;
import com.application.simpleAdvisingSystem.repositories.slotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.security.Principal;
import java.util.List;

@Controller
public class studentController {


    @Autowired
    slotRegisteredStudentRepository slotRegisteredStudentRepository;

    @Autowired
    slotRepository slotRepository;

    @Autowired
    UserRepository userRepository;

    @GetMapping("/student")
    public String normalUser(Model model, Principal principal){

        List<slot> slots = slotRepository.findAll();
        model.addAttribute("slots", slots);

        String currentLogInUserEmail = principal.getName();
        slotRegisteredStudents bookResult = slotRegisteredStudentRepository.findByEmail(currentLogInUserEmail);

        User currentLogInStudent = userRepository.findByEmail(currentLogInUserEmail);
        model.addAttribute("currentLogInStudent", currentLogInStudent);

        String bookingStatus = "";

        if(bookResult != null){
            // already booked
            bookingStatus = "You have booked your time in " + bookResult.getSlotID() + ". ";
        }else{
            bookingStatus = "You have not booked any slot yet. Only after booking you can cancel here : ";
        }

        model.addAttribute("bookingStatus", bookingStatus);

        return "student/student";

    }



    @RequestMapping(value = "/book_slot", method  = RequestMethod.POST)
    public String bookSlot(@ModelAttribute("slotRegisteredStudent") slotRegisteredStudents student, Model model, HttpSession session){

        slotRegisteredStudents alreadyBooked = slotRegisteredStudentRepository.findByEmail(student.getEmail());

        if(alreadyBooked == null){

            // akhono book kore nai

            try{
                slotRegisteredStudentRepository.save(student);
                session.setAttribute("message", new Message("Successfully Registered your slot!", "alert-success"));
            }catch (Exception e){
                e.printStackTrace();
                session.setAttribute("message", new Message("something went wrong", "alert-danger"));
            }

        }else {

            // ei email diye alrady book kore felse ekta slot.

            session.setAttribute("message", new Message("sorry, you have already booked a slot by this email. First cancel it and then book again!", "alert-danger"));
        }

        return "redirect:/student";
    }



    @RequestMapping("/cancelBooking")
    public String booking_cancel(Model model, Principal principal, HttpSession session){

        String currentLogInUser = principal.getName();
        slotRegisteredStudents bookResult = slotRegisteredStudentRepository.findByEmail(currentLogInUser);

        if(bookResult != null){
            // user has booking

            slotRegisteredStudentRepository.delete(bookResult);
            session.setAttribute("message", new Message("successfully canceled your booked slot.", "alert-success"));

        }else{
            // user has not any booking yet

            session.setAttribute("message", new Message("sorry, you don't have any booking yet.", "alert-danger"));
        }

        return "redirect:/student";
    }

}
