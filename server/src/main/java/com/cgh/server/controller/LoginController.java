package com.cgh.server.controller;

import com.cgh.server.domain.User;
import com.cgh.server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    UserService userService;

    @GetMapping("")
    public String login() {
        return "login";
    }

    @GetMapping("/signup")
    public String signup(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "signup";
    }

    @PostMapping("/signup")
    public String signup(User user) {
        userService.save(user);
        return "redirect:/login";
    }

}
