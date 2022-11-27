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
        System.out.print("list size is : " + students.size());
        model.addAttribute("students", students);

        return "lecturer/lecturer";
    }


    // slot adding option pore dynamically add kora jabe. apatoto eikhane ekta
    // manual command diye 4 ta slot thik kore dicchi. pore eta ke dynamic
    // korte chaile first e eikhane admin ke slot add korar ekta option dibo
    // then admin slot add kore submit korar pore oi ta slot repo te save kore
    // dibo. then oi slot repo theke slot gular list catch kore student controller
    // e ekta attribute a add kore student page e pathay dibo. then student page er
    // select option oi attribute theke list ke cathch kore oita option e add kore
    // dibo ekkta ekta kore





}
