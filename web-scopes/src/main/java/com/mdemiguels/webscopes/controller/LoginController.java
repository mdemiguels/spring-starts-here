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

    public LoginController(LoginProcessor logginUtility) {
        this.loginUtility = logginUtility;
    }

    @GetMapping("/")
    public String loginGet() {
        return "login";
    }

    @PostMapping("/")
    public String loginPost(@RequestParam String username,
                            @RequestParam String password,
                            Model model) {
        User user = new User(username, password);

        if (loginUtility.checkUser(user)) {
            model.addAttribute("message", "User verified");
            return "login";
        }

        model.addAttribute("message", "User incorrect");
        return "login";
    }
}
