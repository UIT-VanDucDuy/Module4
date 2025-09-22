package com.example.bt5.controller;

import com.example.bt5.entity.Product;
import com.example.bt5.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping ("/products")
public class ProductController {
    @ModelAttribute("subjects")
    public List<String> getSubjects(){
        return Arrays.asList("Food", "","SQL");
    }
    @Autowired
    private IProductService productService;

    @RequestMapping(value = "",method = RequestMethod.GET)
    public ModelAndView showList(){
        ModelAndView modelAndView = new ModelAndView("/product/list");
        modelAndView.addObject("productList", productService.findAll());
        return modelAndView;
    }

    @GetMapping ("/add")
    public String showFormAdd(Model model){
        model.addAttribute("product", new Product());
        return "/product/add";
    }
    @PostMapping("/add")
    public String save(@ModelAttribute(name = "product") Product product,
                       RedirectAttributes redirectAttributes){
        productService.add(product);
        redirectAttributes.addFlashAttribute("mess","add success");
        return "redirect:/products";
    }
    @GetMapping("/detail")
    public String detail(@RequestParam(name = "id",required = false,defaultValue = "3")int id,
                         Model model
    ){
        Product product = productService.findById(id);
        model.addAttribute("product", product);
        return "/product/detail";
    }

    @GetMapping("/detail/{id}")
    public String detail2(@PathVariable(name = "id")int id,
                          Model model
    ){
        Product product = productService.findById(id);
        model.addAttribute("product", product);
        return "/product/detail";
    }
}
