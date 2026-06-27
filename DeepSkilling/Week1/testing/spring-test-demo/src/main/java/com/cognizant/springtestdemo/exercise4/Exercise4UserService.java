package com.cognizant.springtestdemo.exercise4;

import org.springframework.stereotype.Service;

@Service
public class Exercise4UserService {
    private final Exercise4UserRepository userRepository;

    public Exercise4UserService(Exercise4UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Exercise4User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public Exercise4User saveUser(Exercise4User user) {
        return userRepository.save(user);
    }
}
