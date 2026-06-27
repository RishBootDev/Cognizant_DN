package com.cognizant.mockitotestdemo.exercise1;

import org.springframework.stereotype.Service;

@Service("exercise1UserService")
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }
}
