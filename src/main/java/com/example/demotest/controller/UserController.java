package com.example.demotest.controller;

import com.example.demotest.model.User;
import com.example.demotest.request.LoginRequest;
import com.example.demotest.request.LogoutRequest;
import com.example.demotest.response.LogoutResponse;
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

    @PostMapping("/logout")
    public LogoutResponse logout(@RequestBody LogoutRequest request) {
        // Thực hiện logic đăng xuất, ví dụ: kiểm tra session trong sessionDatabase
        if (sessionDatabase.containsKey(request.getSession())) {
            // Đăng xuất thành công
            sessionDatabase.remove(request.getSession());
            LogoutResponse response = new LogoutResponse();
            response.setCode("LOGOUT_OK");
            return response;
        } else {
            // Session không hợp lệ
            LogoutResponse response = new LogoutResponse();
            response.setCode("UNAUTHORIZED");
            return response;
        }
    }


// Other endpoints for user
