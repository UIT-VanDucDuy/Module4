package com.example.signupvalidation.repository;


import com.example.signupvalidation.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISignupRepository extends JpaRepository<User, Long> {
}
