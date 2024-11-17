package com.mdemiguels.webscopes.controller;

import com.mdemiguels.webscopes.model.User;
import com.mdemiguels.webscopes.utilities.LoginProcessor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    private final LoginProcessor loginUtility;

    public LoginController(LoginProcessor loginUtility) {
        this.loginUtility = loginUtility;
    }

    @GetMapping("/")
    public String loginGet() {
        return "login";
    }

    @PostMapping("/")
    public String loginPost(@RequestParam String username,
                            @RequestParam String password,
                            Model model) {

        boolean loggedIn = false;

        if (loggedIn) {
            model.addAttribute("message", "User verified");
        } else {
            model.addAttribute("message", "User incorrect");
        }

        return "login";
    }
}
