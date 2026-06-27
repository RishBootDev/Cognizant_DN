package com.cognizant.springtestdemo.exercise3;

import org.springframework.stereotype.Service;

@Service
public class Exercise3UserService {
    private final Exercise3UserRepository userRepository;

    public Exercise3UserService(Exercise3UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Exercise3User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public Exercise3User saveUser(Exercise3User user) {
        return userRepository.save(user);
    }
}
