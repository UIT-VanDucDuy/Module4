package com.example.borrowbook.controller;

import com.example.borrowbook.service.BookService;
import com.example.borrowbook.service.BorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class BookController {
    @Autowired
    private BookService bookService;
    @Autowired
    private BorrowService borrowService;

    @GetMapping("/books")
    public String listBooks(Model model) {
        model.addAttribute("books", bookService.findAll());
        return "books";
    }

    @GetMapping("/books/{id}")
    public String bookDetail(@PathVariable int id, Model model) {
        model.addAttribute("book", bookService.getBook(id));
        return "book-detail";
    }

    @PostMapping("/books/{id}/borrow")
    public String borrow(@PathVariable int id, Model model) {
        String code = borrowService.borrowBook(id);
        model.addAttribute("message", "Mã mượn sách của bạn là: " + code);
        return "book-detail";
    }
}
