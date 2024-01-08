package com.example.demotest.service;

import com.example.demotest.model.User;
import com.example.demotest.repository.UserRepository;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void signUp(User user) {
        // Validate and save user registration
        if (user == null || user.getUsername() == null || user.getPassword() == null) {
            throw new IllegalArgumentException("Invalid user data");
        }

        if (userRepository.existsByUsername(user.getUsername())) {
            throw new IllegalStateException("Username already exists");
        }

        user.setRole("STUDENT"); // Assuming the default role is "STUDENT"
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        userRepository.save(user);
    }

    public String signIn(String username, String password) {
        // Validate user login credentials
        if (username == null || password == null) {
            throw new IllegalArgumentException("Invalid login credentials");
        }

        Optional<User> userOptional = userRepository.findByUsername(username);

        if (userOptional.isPresent() && passwordEncoder.matches(password, userOptional.get().getPassword())) {
            // If credentials are valid, return a token or user identifier
            return generateToken(username, userOptional.get().getRole());
        } else {
            // If credentials are invalid, you can handle it accordingly
            return null;
        }
    }

    private String generateToken(String username, String role) {
        long validityInMilliseconds = 1800000; // 30 minutes

        // Tạo JWT token
        return Jwts.builder()
                .setSubject(username)
                .claim("role", role)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + validityInMilliseconds))
                .signWith(SignatureAlgorithm.HS256, "kuboSecret9898")
                .compact();
    }
}
