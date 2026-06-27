package com.cognizant.springtestdemo.exercise2;

import org.springframework.stereotype.Service;

@Service
public class Exercise2UserService {
    private final Exercise2UserRepository userRepository;

    public Exercise2UserService(Exercise2UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Exercise2User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public Exercise2User saveUser(Exercise2User user) {
        return userRepository.save(user);
    }
}
