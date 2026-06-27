package com.cognizant.springtestdemo.exercise8;

import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

@Service
public class Exercise8UserService {
    private final Exercise8UserRepository userRepository;

    public Exercise8UserService(Exercise8UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Exercise8User getUserById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new NoSuchElementException("User not found"));
    }

    public Exercise8User saveUser(Exercise8User user) {
        return userRepository.save(user);
    }
}
