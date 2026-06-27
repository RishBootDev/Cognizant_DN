package com.cognizant.springtestdemo.exercise7;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
class Exercise7UserRepositoryTest {
    @Autowired
    private Exercise7UserRepository userRepository;

    @Test
    void findByNameReturnsMatchingUsers() {
        userRepository.save(new Exercise7User(null, "Rishabh"));
        userRepository.save(new Exercise7User(null, "Rishabh"));
        userRepository.save(new Exercise7User(null, "Amit"));

        List<Exercise7User> users = userRepository.findByName("Rishabh");

        assertEquals(2, users.size());
        assertEquals("Rishabh", users.get(0).getName());
    }
}
