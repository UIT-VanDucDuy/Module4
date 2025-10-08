package com.example.blog.controller;

import com.example.blog.entity.Blog;
import com.example.blog.entity.Category;
import com.example.blog.repository.IBlogRepository;
import com.example.blog.service.IBlogService;
import com.example.blog.service.ICategoryService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("blogs")
public class BlogController {

    private final IBlogService blogService;
    private final ICategoryService categoryService;

    @Autowired
    public BlogController(IBlogService blogService, ICategoryService categoryService) {
        this.blogService = blogService;
        this.categoryService = categoryService;
    }

    // Trang chính: danh sách + form
    @GetMapping
    public ModelAndView showBlogs(
            @RequestParam(name = "page", required = false, defaultValue = "0") int page,
            @RequestParam(name = "category", required = false,defaultValue = " ") String categoryName) {
        Pageable pageable = PageRequest.of(page, 5, Sort.by("createdAt").descending());
        Category category = categoryService.getCategoryByName(categoryName);
        Page<Blog> blogPage = blogService.getBlogsbyCategory(category, pageable);
        ModelAndView modelAndView = new ModelAndView("blogs");
        modelAndView.addObject("blogPage", blogPage);
        modelAndView.addObject("categories", categoryService.getAllCategories());
        modelAndView.addObject("newBlog", new Blog());
        modelAndView.addObject("selectedCategory", categoryName);
        return modelAndView;
    }

    // Lưu bài viết mới
    @PostMapping
    public String saveBlog(@ModelAttribute("newBlog") Blog blog) {
        blogService.saveBlog(blog);
        return "redirect:/blogs";
    }

    // Xóa bài viết
    @GetMapping("/delete/{id}")
    public String deleteBlog(@PathVariable int id) {
        blogService.deleteBlog(id);
        return "redirect:/blogs";
    }
}
