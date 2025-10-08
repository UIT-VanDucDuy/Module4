package com.example.signupvalidation.service;

import com.example.signupvalidation.entity.User;
import com.example.signupvalidation.repository.ISignupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SignupService implements ISignupService {
    @Autowired
    private ISignupRepository signupRepository;

    public SignupService(ISignupRepository signupRepository) {
        this.signupRepository = signupRepository;
    }
    @Override
    public User signUp(User user) {
        return signupRepository.save(user);
    }
}
