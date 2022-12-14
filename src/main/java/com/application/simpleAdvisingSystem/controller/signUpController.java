package com.application.simpleAdvisingSystem.controller;


import com.application.simpleAdvisingSystem.helper.Message;
import com.application.simpleAdvisingSystem.models.User;
import com.application.simpleAdvisingSystem.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

@Controller
public class signUpController {

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;


    @RequestMapping("/signUp")
    public String signUP(Model model){
        model.addAttribute("title", "Register Account");
        model.addAttribute("user", new User());
        return "signUp";
    }


    //handler for registering user
    @RequestMapping(value = "/do_register", method = RequestMethod.POST)
    public String registerUser(@ModelAttribute("user") User user, Model model, HttpSession session){


        try{

            String role = "ROLE_"+user.getRole();
            user.setRole(role);

            User checkDuplicate = userRepository.findByEmail(user.getEmail());
            if(checkDuplicate == null){
                user.setPassword(passwordEncoder.encode(user.getPassword()));
                User UserResult = this.userRepository.save(user);
                model.addAttribute("user", new User());
                session.setAttribute("message", new Message("Successfully Registered !!", "alert-success"));

            }else{
                model.addAttribute("user", user);

                user.setRole(user.getRole().substring(5, user.getRole().length())); // setting the role without 'ROLE_' while form is returning back with info.

                session.setAttribute("message", new Message("Please give an unique email address.", "alert-danger"));
            }

            return "signUp";


        }catch (Exception e){
            e.printStackTrace();
            model.addAttribute("user", user);
            session.setAttribute("message", new Message("Something went wrong !!" + e.getMessage(), "alert-danger"));

            return "signUp";
        }

    }

}
