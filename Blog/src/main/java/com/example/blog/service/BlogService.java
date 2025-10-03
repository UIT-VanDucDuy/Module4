package com.example.blog.service;

import com.example.blog.entity.Blog;
import com.example.blog.repository.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BlogService implements IBlogService {
    @Autowired
    private IBlogRepository blogRepository;

    public BlogService(IBlogRepository blogRepository) {
        this.blogRepository = blogRepository;
    }

    public Blog createBlog(Blog blog) {
        return blogRepository.save(blog);
    }

    public List<Blog> getAllBlogs() {
        return blogRepository.findAll();
    }

    public Blog getBlogById(int id) {
        return blogRepository.findById(id).orElse(null);
    }

    @Override
    public Blog saveBlog(Blog blog) {
        return blogRepository.save(blog);
    }
    public Blog updateBlog(int id, Blog updatedBlog) {
        return blogRepository.findById(id).map(blog -> {
            blog.setTitle(updatedBlog.getTitle());
            blog.setSummary(updatedBlog.getSummary());
            blog.setContent(updatedBlog.getContent());
            return blogRepository.save(blog);
        }).orElse(null);
    }

    public boolean deleteBlog(int id) {
        if (blogRepository.existsById(id)) {
            blogRepository.deleteById(id);
            return true; // Xoá thành công
        }
        return false; // Không tồn tại
    }

}
