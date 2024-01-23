package com.example.demotest.service;

import com.example.demotest.model.User;
import com.example.demotest.repository.UserRepository;
import com.example.demotest.request.LoginRequest;
import com.example.demotest.request.LogoutRequest;
import com.example.demotest.request.RegisterRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public ResponseEntity<String> register(RegisterRequest request){
        if(userRepository.existsByUsername((request.getUsername()))){
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body("{\"code\":\"REGISTER_CONFLICT\",\"error_message\":\"username is existed\"}");
        }

        if(!isValidRole(request.getRole())){
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("{\"code\":\"REGISTER_NOT_FOUND\",\"error_message\":\"role is invalid\"}");

        }
        User newUser = new User();
        newUser.setUsername(request.getUsername());
        newUser.setPassword(request.getPassword());
        newUser.setFullname(request.getFullname());
        newUser.setRole(request.getRole());

        userRepository.save(newUser);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body("{\"code\":\"REGISTER_CREATED\",\"session\":\"example\"}");
    }

    private boolean isValidRole(String role) {
        return "teacher".equals(role) || "student".equals(role);
    }

    public ResponseEntity<String> login(LoginRequest request) {
        // Tìm kiếm người dùng trong cơ sở dữ liệu
        Optional<User> userOptional = userRepository.findByUsernameAndPassword(request.getUsername(), request.getPassword());

        if (userOptional.isPresent()) {
            User user = userOptional.get();
            // log in successfully
            return ResponseEntity.ok("{\"code\":\"LOGIN_OK\",\"fullname\":\"" + user.getFullname() + "\",\"role\":\"" + user.getRole() + "\"}");
        } else {
            // login failed
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body("{\"code\":\"UNAUTHORIZED\",\"error_message\":\"username or password is incorrect\"}");
        }
    }

    public ResponseEntity<String> logout(LogoutRequest request) {
        // Xử lý đăng xuất, ví dụ: hủy phiên làm việc
        // ...

        // Trả về phản hồi đăng xuất thành công
        return ResponseEntity.ok("{\"code\":\"LOGOUT_OK\"}");
    }



}
