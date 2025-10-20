package com.example.blog.restController;

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
    public Page<Blog> getBlogs(
            @RequestParam(required = false) String category,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size
    ) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("createdAt").descending());

        if (category != null && !category.isEmpty()) {
            Category cat = categoryService.getCategoryByName(category);
            if (cat == null) {
                // Nếu category không tồn tại, trả về trang rỗng
                return Page.empty(pageable);
            }
            return blogService.getBlogsbyCategory(cat, pageable);
        }

        // Nếu không có category -> lấy tất cả
        return blogService.getBlogsbyCategory(null, pageable);
    }
    @PostMapping
    public Blog createBlog(@RequestBody Blog blog) {
        blogService.saveBlog(blog);
        return blog;
    }

    @DeleteMapping("/{id}")
    public void deleteBlog(@PathVariable int id) {
        blogService.deleteBlog(id);
    }
}
