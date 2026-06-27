package com.cognizant.springtestdemo.exercise8;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/exercise8/users")
public class Exercise8UserController {
    private final Exercise8UserService userService;

    public Exercise8UserController(Exercise8UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Exercise8User> getUser(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }}
