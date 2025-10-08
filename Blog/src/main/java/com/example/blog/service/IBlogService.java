package com.example.blog.service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.blog.entity.Blog;
import com.example.blog.entity.Category;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IBlogService {
    List<Blog> getAllBlogs();
    Blog saveBlog(Blog blog);
    boolean deleteBlog(int id);
    Page<Blog> getBlogsbyCategory(Category category, Pageable pageable);
}