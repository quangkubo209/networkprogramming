package com.example.demotest.controller;

import com.example.demotest.model.User;
import com.example.demotest.repository.UserRepository;
import com.example.demotest.request.LoginRequest;
import com.example.demotest.request.LogoutRequest;
import com.example.demotest.request.RegisterRequest;
import com.example.demotest.response.LogoutResponse;
import com.example.demotest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @GetMapping("/getAllUser")
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    @PostMapping("/create")
    public User createUser(@RequestBody User user) {
        return userRepository.save(user);
    }

    @MessageMapping("register")
    @SendTo("topic/registration")
    public ResponseEntity<String> registration(RegisterRequest request){
        return userService.register(request);
    }

    @MessageMapping("/login")
    @SendTo("/topic/authentication")
    public ResponseEntity<String> login(LoginRequest request) {
        // Xử lý yêu cầu đăng nhập và gửi phản hồi đến người gửi
        return userService.login(request);
    }

    @MessageMapping("/logout")
    @SendTo("/topic/authentication")
    public ResponseEntity<String> logout(LogoutRequest request) {
        // Xử lý yêu cầu đăng xuất và gửi phản hồi đến người gửi
        return userService.logout(request);
    }
}


