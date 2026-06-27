package com.cognizant.springtestdemo.exercise5;

import org.springframework.stereotype.Service;

@Service
public class Exercise5UserService {
    private final Exercise5UserRepository userRepository;

    public Exercise5UserService(Exercise5UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Exercise5User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public Exercise5User saveUser(Exercise5User user) {
        return userRepository.save(user);
    }
}
