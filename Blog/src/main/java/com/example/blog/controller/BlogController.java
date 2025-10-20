    package com.example.blog.controller;
    
    import com.example.blog.entity.Blog;
    import com.example.blog.entity.Category;
    import com.example.blog.service.IBlogService;
    import com.example.blog.service.ICategoryService;
    import jakarta.servlet.http.Cookie;
    import jakarta.servlet.http.HttpServletResponse;
    import jakarta.servlet.http.HttpServletRequest;
    import jakarta.servlet.http.HttpSession;
    import org.springframework.data.domain.Page;
    import org.springframework.data.domain.PageRequest;
    import org.springframework.data.domain.Pageable;
    import org.springframework.data.domain.Sort;
    import org.springframework.stereotype.Controller;
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
    
        @GetMapping
        public ModelAndView showBlogs(
                @RequestParam(name = "page", required = false, defaultValue = "0") int page,
                @RequestParam(name = "category", required = false) String categoryName,
                HttpServletRequest request,
                HttpServletResponse response,
                HttpSession session
        ) {
            if (categoryName != null && !categoryName.isBlank()) {
                Cookie categoryCookie = new Cookie("lastCategory", categoryName);
                categoryCookie.setMaxAge(7 * 24 * 60 * 60); // 7 ngày
                categoryCookie.setPath("/");
                response.addCookie(categoryCookie);
            } else {
                categoryName = getCookieValue(request, "lastCategory", "");
            }
    
            Integer viewCount = (Integer) session.getAttribute("viewCount");
            if (viewCount == null) viewCount = 0;
            session.setAttribute("viewCount", ++viewCount);
    
            Pageable pageable = PageRequest.of(page, 5, Sort.by("createdAt").descending());
            Category category = categoryService.getCategoryByName(categoryName);
            Page<Blog> blogPage = blogService.getBlogsbyCategory(category, pageable);
    
            ModelAndView modelAndView = new ModelAndView("blogs");
            modelAndView.addObject("blogPage", blogPage);
            modelAndView.addObject("categories", categoryService.getAllCategories());
            modelAndView.addObject("newBlog", new Blog());
            modelAndView.addObject("selectedCategory", categoryName);
            modelAndView.addObject("viewCount", viewCount);
            return modelAndView;
        }
    
        // ✅ Lưu bài viết mới
        @PostMapping
        public String saveBlog(@ModelAttribute("newBlog") Blog blog) {
            blogService.saveBlog(blog);
            return "redirect:/blogs";
        }
    
        // ✅ Xoá bài viết
        @GetMapping("/delete/{id}")
        public String deleteBlog(@PathVariable int id) {
            blogService.deleteBlog(id);
            return "redirect:/blogs";
        }
    
        // 🔸 Hàm tiện ích đọc cookie
        private String getCookieValue(HttpServletRequest request, String name, String defaultValue) {
            if (request.getCookies() != null) {
                for (Cookie cookie : request.getCookies()) {
                    if (cookie.getName().equals(name)) {
                        return cookie.getValue();
                    }
                }
            }
            return defaultValue;
        }
    }
