package com.cognizant.mockitotestdemo.exercise2;

import org.springframework.stereotype.Service;

@Service("exercise2UserService")
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }
}
