package com.example.blog.RestController;

import com.example.blog.entity.Blog;
import com.example.blog.entity.Category;
import com.example.blog.service.IBlogService;
import com.example.blog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/blogs")
public class BlogRestController {
    private final IBlogService blogService;
    private final ICategoryService categoryService;

    @Autowired
    public BlogRestController(IBlogService blogService, ICategoryService categoryService) {
        this.blogService = blogService;
        this.categoryService = categoryService;
    }

    @GetMapping
    public Page<Blog> getAllBlogs(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size
    ) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("createdAt").descending());
        return blogService.getBlogsbyCategory(null, pageable);
    }

    @GetMapping("/category/{categoryName}")
    public Page<Blog> getBlogsByCategory(
            @PathVariable String categoryName,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size
    ) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("createdAt").descending());
        Category category = categoryService.getCategoryByName(categoryName);
        return blogService.getBlogsbyCategory(category, pageable);
    }
}
