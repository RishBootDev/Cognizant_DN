package com.cognizant.springtestdemo.exercise5;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/exercise5/users")
public class Exercise5UserController {
    private final Exercise5UserService userService;

    public Exercise5UserController(Exercise5UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Exercise5User> getUser(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }

    @PostMapping
    public ResponseEntity<Exercise5User> createUser(@RequestBody Exercise5User user) {
        return ResponseEntity.ok(userService.saveUser(user));
    }
}
