package com.example.signupvalidation.controller;

import com.example.signupvalidation.entity.User;
import com.example.signupvalidation.service.ISignupService;
import com.example.signupvalidation.service.SignupService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("")
public class SignupController {
    @Autowired
    private ISignupService signupService;

    @GetMapping("")
    public String showForm(Model model) {
        model.addAttribute("user", new User());
        return "signup";
    }

    @PostMapping("/register")
    public String register(@Valid User user, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "signup";
        }

        signupService.signUp(user);
        model.addAttribute("success", true);
        return "signup";
    }
}
