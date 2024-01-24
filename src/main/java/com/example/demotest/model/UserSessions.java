package com.example.demotest.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;


@Getter
@Setter
@Entity
@Table(name = "user_sessions")
public class UserSessions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "session_key")
    private String sessionKey;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "expires_at")
    private LocalDateTime expiresAt;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;


}
