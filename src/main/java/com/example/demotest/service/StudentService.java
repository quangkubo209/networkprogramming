package com.example.demotest.service;

import com.example.demotest.model.User;
import com.example.demotest.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    public void signUp(User student) {
        // Validate and save student registration
        student.setRole("STUDENT"); // Đặt vai trò cho sinh viên
        userRepository.save(student);
    }

    public String signIn(String username, String password) {
        // Validate student login credentials
        // ...

        Optional<User> user = userRepository.findByUsername(username);

        if (user.isPresent() && passwordEncoder.matches(password, user.get().getPassword())) {
            String token = jwtTokenProvider.createToken(username, user.get().getRole());
            return token;
        } else {
            // Xử lý khi đăng nhập không thành công
            // ...
        }
    }

    // Các logic khác cho chức năng sinh viên
    // ...

}
