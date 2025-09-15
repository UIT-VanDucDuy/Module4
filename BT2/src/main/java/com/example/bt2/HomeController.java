package com.example.bt2;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class HomeController {
    @GetMapping(value = "/home")
    public String showHome() {
        return "home";
    }
    @GetMapping(value = "/home/sandwich")
    public String showSandwichForm(Model model) {
        List<String> allSpices = List.of(
                "Mayonnaise", "Mustard", "Ketchup", "Lettuce", "Tomato", "Pickles", "Chili"
        );
        List<String> allSandwices = allSpices;
        model.addAttribute("allSpices", allSpices);
        return "sandwich/sandwichForm";
    }
    @PostMapping("/home/sandwich")
    public String save(@RequestParam("spices") List<String> spices, Model model) {
        model.addAttribute("chosenSpices", spices);
        return "sandwich/sandwichResult";
    }
    @GetMapping("/home/calculator")
    public String showCalculator(Model model) {
        return "calculator";
    }
    @PostMapping("/home/calculator")
    public String calculate(@RequestParam("num1") int num1, @RequestParam("num2") int num2,
                            @RequestParam("operator") String operator
            , Model model) {
        double result = 0;
        String opName= null;

        switch (operator) {
            case "add":
                result = num1 + num2;
                opName = "Addition";
                break;
            case "sub":
                result = num1 - num2;
                opName = "Subtraction";
                break;
            case "mul":
                result = num1 * num2;
                opName = "Multiplication";
                break;
            case "div":
                if (num2 != 0) {
                    result = num1 / num2;
                } else {
                    model.addAttribute("error", "Cannot divide by zero!");
                }
                opName = "Division";
                break;
        }

        model.addAttribute("num1", num1);
        model.addAttribute("num2", num2);
        model.addAttribute("result", result);
        model.addAttribute("operator",opName);
        return "calculator";
    }
}
