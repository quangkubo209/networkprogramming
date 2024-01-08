package com.example.demotest.controller;

import com.example.demotest.model.User;
import com.example.demotest.request.LoginRequest;
import com.example.demotest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/signup")
    public ResponseEntity<String> signUp(@RequestBody User user) {
        // Validate and process user registration
        userService.signUp(user);
        return ResponseEntity.ok("User registered successfully!");
    }

    @PostMapping("/signin")
    public ResponseEntity<String> signIn(@RequestBody LoginRequest loginRequest) {
        // Validate and process user login
        String token = userService.signIn(loginRequest.getUsername(), loginRequest.getPassword());
        return ResponseEntity.ok(token);
    }

// Other endpoints for user
