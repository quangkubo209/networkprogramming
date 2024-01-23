package com.example.demotest.model;

import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public void setUsername(String username) {
        this.username = username;
    }

    @Getter
    private String username;

    public void setPassword(String password) {
        this.password = password;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Getter
    private String password;

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    @Getter
    private String fullname;

    public void setRole(String role) {
        this.role = role;
    }

    @Getter
    private String role;


    @Column(name = "created_at")
    private LocalDateTime createdAt;

    public User() {
    }

    // constructor
    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
    }

    // getters and setters
}
