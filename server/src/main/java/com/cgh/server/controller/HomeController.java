package com.cgh.server.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class HomeController {

    @GetMapping("")
    public String home(Model model, @AuthenticationPrincipal User user) {
        if (user != null) {
            model.addAttribute("currentUser", user);
        }
        return "home";
    }
}
