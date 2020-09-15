package com.skibnev.springbootwebsocketchat.controller;

import com.skibnev.springbootwebsocketchat.domain.User;
import com.skibnev.springbootwebsocketchat.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;

@Controller
public class MainController {

    @Autowired
    private UserService userService;

    private static final Logger log = Logger.getLogger(MainController.class);

    @GetMapping("/")
    public String homePage(){
        return "homePage";
    }


    @GetMapping("/chat")
    public String showChat(Principal principal, Model model){
        String username = principal.getName();
        log.info("Username is: " + username);
        model.addAttribute("username", username);
        return "chat";
    }
    @GetMapping("/registration")
    public String registration(){
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(User user){
        if (!userService.saveUser(user)){
            log.error("User already exists in the database");
            return "registration";
        }
        log.info("New user saved in the database");
        return "redirect:/login";
    }
}
