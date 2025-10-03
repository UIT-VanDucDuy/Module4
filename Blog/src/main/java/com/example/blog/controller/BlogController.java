package com.example.blog.controller;

import com.example.blog.entity.Blog;
import com.example.blog.service.IBlogService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;


@Controller
@RequestMapping("")
public class BlogController {

    private final IBlogService blogService;

    @Autowired
    public BlogController(IBlogService blogService) {
        this.blogService = blogService;
    }

    // Danh sách blog
    @GetMapping
    public String listBlogs(Model model) {
        model.addAttribute("blogs", blogService.getAllBlogs());
        return "blogs"; // -> blogs.html
    }

    // Xem chi tiết
    @GetMapping("/{id}")
    public String viewBlog(@PathVariable int id, Model model) {
        model.addAttribute("blog", blogService.getBlogById(id));
        return "blog-detail"; // -> blog-detail.html
    }

    // Form thêm mới
    @GetMapping("/new")
    public String newBlogForm(Model model) {
        model.addAttribute("blog", new Blog());
        return "blog-form";
    }

    // Lưu blog mới
    @PostMapping
    public String saveBlog(@ModelAttribute Blog blog) {
        blogService.saveBlog(blog);
        return "redirect:/blogs";
    }

    // Form cập nhật
    @GetMapping("/edit/{id}")
    public String editBlogForm(@PathVariable int id, Model model) {
        model.addAttribute("blog", blogService.getBlogById(id));
        return "blog-form";
    }

    // Xử lý cập nhật
    @PostMapping("/update/{id}")
    public String updateBlog(@PathVariable int id, @ModelAttribute Blog updatedBlog) {
        blogService.updateBlog(id, updatedBlog);
        return "redirect:/blogs";
    }

    // Xoá
    @GetMapping("/delete/{id}")
    public String deleteBlog(@PathVariable int id) {
        blogService.deleteBlog(id);
        return "redirect:/blogs";
    }
}
