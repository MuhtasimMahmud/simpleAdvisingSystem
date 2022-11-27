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
    slotRepository slotsSlotRepository;

    @GetMapping("/lecturer")
    public String adminUser(Model model){

        List<slotRegisteredStudents> students = studentRepository.findAll();
//        System.out.print("list size is : " + students.size());
        model.addAttribute("students", students);

        // ei method eikhane just ekbar run houar porei comment kore disi. naile bar bar
        // hoite thakbe
//        addSlots();

        return "lecturer/lecturer";
    }


    @RequestMapping("/create_slot")
    public String createSlot(@ModelAttribute("newSlot") slot slot, Model model, HttpSession session){

        try{
            slotsSlotRepository.save(slot);
            session.setAttribute("message", new Message("new slot created!", "alert-success"));
        }catch (Exception e){
            e.printStackTrace();
            session.setAttribute("message", new Message("Something went wrong !!" + e.getMessage(), "alert-danger"));
        }

        return "redirect:/lecturer";
    }


    // slot adding option pore dynamically add kora jabe. apatoto eikhane ekta
    // manual command diye 4 ta slot thik kore dicchi. pore eta ke dynamic
    // korte chaile first e eikhane admin ke slot add korar ekta option dibo
    // then admin slot add kore submit korar pore oi ta slot repo te save kore
    // dibo. then oi slot repo theke slot gular list catch kore student controller
    // e ekta attribute a add kore student page e pathay dibo. then student page er
    // select option oi attribute theke list ke cathch kore oita option e add kore
    // dibo ekkta ekta kore


//    public void addSlots(){
//        slotsSlotRepository.save(new slot("slot1", "Monday   15:00 - 17:00", 8));
//        slotsSlotRepository.save(new slot("slot2", "Tuesday  14:00 - 16:00", 8));
//        slotsSlotRepository.save(new slot("slot3", "Thursday 11:00 - 13:00", 8));
//        slotsSlotRepository.save(new slot("slot4", "Friday   10:00 - 12:00", 8));
//
//    }







}
