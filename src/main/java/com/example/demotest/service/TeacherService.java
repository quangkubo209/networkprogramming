package com.example.demotest.service;

import com.example.demotest.model.User;
import com.example.demotest.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TeacherService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    public void signUp(User teacher) {
        // Validate and save teacher registration
        teacher.setRole("TEACHER"); // Đặt vai trò cho giáo viên
        userRepository.save(teacher);
    }

    public String signIn(String username, String password) {
        // Validate teacher login credentials
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

    // Các logic khác cho chức năng giáo viên
    // ...

}
