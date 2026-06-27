package com.cognizant.springtestdemo.exercise7;

import org.springframework.stereotype.Service;

@Service
public class Exercise7UserService {
    private final Exercise7UserRepository userRepository;

    public Exercise7UserService(Exercise7UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Exercise7User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public Exercise7User saveUser(Exercise7User user) {
        return userRepository.save(user);
    }
}
