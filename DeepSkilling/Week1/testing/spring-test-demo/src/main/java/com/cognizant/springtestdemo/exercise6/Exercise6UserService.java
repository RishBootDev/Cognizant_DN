package com.cognizant.springtestdemo.exercise6;

import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

@Service
public class Exercise6UserService {
    private final Exercise6UserRepository userRepository;

    public Exercise6UserService(Exercise6UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Exercise6User getUserById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new NoSuchElementException("User not found"));
    }

    public Exercise6User saveUser(Exercise6User user) {
        return userRepository.save(user);
    }
}
