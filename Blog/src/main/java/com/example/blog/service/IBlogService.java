package com.example.blog.service;

import com.example.blog.entity.Blog;

import java.util.List;

public interface IBlogService {
    Blog createBlog(Blog blog);
    List<Blog> getAllBlogs();
    Blog getBlogById(int id);
    Blog saveBlog(Blog blog);
    Blog updateBlog(int id, Blog blog);
    boolean deleteBlog(int id);
}