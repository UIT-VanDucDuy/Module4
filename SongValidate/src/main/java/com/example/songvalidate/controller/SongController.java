package com.example.songvalidate.controller;

import com.example.songvalidate.Dto.SongDto;
import com.example.songvalidate.entity.Song;
import com.example.songvalidate.validate.SongValidate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
@Controller
@RequestMapping("/songs")
public class SongController {
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.addValidators(new SongValidate());
    }
    @GetMapping("/create")
    public String showForm(Model model) {
        model.addAttribute("song", new Song());
        return "song-form";
    }
    @PostMapping("/create")
    public String saveSong(@ModelAttribute("song") SongDto Song,
                           BindingResult bindingResult, Model model) {
        SongValidate validate = new SongValidate();
        validate.validate(Song, bindingResult);
        if (bindingResult.hasErrors()) {
            return "song-form";
        }
        model.addAttribute("message", "Thêm bài hát thành công!");
        return "song-success";
    }
}
