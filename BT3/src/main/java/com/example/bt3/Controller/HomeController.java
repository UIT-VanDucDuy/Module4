package com.example.bt3.Controller;

import com.example.bt3.Entity.Mail;
import com.example.bt3.Repo.MailRepo;
import com.example.bt3.Service.IMailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class HomeController {
    @Autowired
    private IMailService mailService;

    @GetMapping(value = "/home")
    public String showHome(Model model) {
        Mail mail = mailService.getInfo();
        model.addAttribute("mail", mail);
        return "home";
    }
    @PostMapping("/home")
    public String save(@ModelAttribute(name = "student") Mail mail,
                       RedirectAttributes redirectAttributes){
        mailService.updateInfo(mail);
        redirectAttributes.addFlashAttribute("mess","update success");
        return "redirect:/home";
    }
}
