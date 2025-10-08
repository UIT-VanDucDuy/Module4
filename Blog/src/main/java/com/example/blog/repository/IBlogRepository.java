package com.example.blog.repository;

import com.example.blog.entity.Blog;
import com.example.blog.entity.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBlogRepository extends JpaRepository<Blog, Integer> {
    Page<Blog> getAllBlogsByCategory(Category catrgory, Pageable pageable);
}
