package com.example.demo2.Controller;

import jakarta.servlet.ServletException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

@Controller
public class HomeController {
    @GetMapping(value = "/home")
    public String showHome() {
        return "home";
    }
    @GetMapping(value = "/home/exchangeMoney")
    public String exchangeMoney() {
        return "exchangeMoney";
    }
    @GetMapping(value = "/home/dictionary")
    public String dictionary() {
        return "dictionary";
    }
    @PostMapping(value = "/home/exchangeMoney")
    public String exchangeMoney(@RequestParam("usd") int usd, Model model) {
        model.addAttribute("usd", usd);
        double vnd = usd * 26.3;
        model.addAttribute("vnd", vnd);
        return "exchangeMoney";
    }
    @PostMapping(value = "/home/dictionary")
    public String dictionaryPost(@RequestParam("word") String word,Model model) {
        Map<String, String> dictionary = new HashMap<>();
        dictionary.put("hello", "xin chào");
        dictionary.put("dog", "con chó");
        dictionary.put("cat", "con mèo");
        dictionary.put("computer", "máy tính");
        dictionary.put("book", "quyển sách");
        dictionary.put("school", "trường học");

        String meaning = dictionary.get(word.trim().toLowerCase());
        if (meaning != null) {
            model.addAttribute("word", word);
            model.addAttribute("meaning", meaning);
        } else {
            model.addAttribute("word", word);
            model.addAttribute("error", "Không tìm thấy từ");
        }
        return "dictionary";

    }
}
