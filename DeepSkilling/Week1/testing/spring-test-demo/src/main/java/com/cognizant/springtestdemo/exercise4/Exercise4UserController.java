package com.cognizant.springtestdemo.exercise4;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/exercise4/users")
public class Exercise4UserController {
    private final Exercise4UserService userService;

    public Exercise4UserController(Exercise4UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Exercise4User> getUser(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }

    @PostMapping
    public ResponseEntity<Exercise4User> createUser(@RequestBody Exercise4User user) {
        return ResponseEntity.ok(userService.saveUser(user));
    }
}
