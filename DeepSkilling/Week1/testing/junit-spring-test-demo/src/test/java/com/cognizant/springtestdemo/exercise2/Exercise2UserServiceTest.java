package com.cognizant.springtestdemo.exercise2;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class Exercise2UserServiceTest {
    @Mock
    private Exercise2UserRepository userRepository;

    @InjectMocks
    private Exercise2UserService userService;

    @Test
    void getUserByIdReturnsUserFromRepository() {
        Exercise2User user = new Exercise2User(1L, "Rishabh");
        when(userRepository.findById(1L)).thenReturn(Optional.of(user));

        Exercise2User result = userService.getUserById(1L);

        assertNotNull(result);
        assertEquals("Rishabh", result.getName());
    }
}
