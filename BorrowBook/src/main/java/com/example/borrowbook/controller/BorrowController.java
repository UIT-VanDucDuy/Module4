package com.example.borrowbook.controller;

import com.example.borrowbook.service.BorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BorrowController {
    @Autowired
    private BorrowService borrowService;

    @GetMapping("/return")
    public String returnPage() {
        return "return-book";
    }

    @PostMapping("/return")
    public String returnBook(@RequestParam String code, Model model) {
        borrowService.returnBook(code);
        model.addAttribute("message", "Trả sách thành công!");
        return "return-book";
    }
}
