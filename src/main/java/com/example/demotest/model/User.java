package com.example.demotest.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;


    @Getter
    @Setter
    private String username;

    @Getter
    private String password;
    private String role;
    @Getter
    private String fullname;


    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "teacher", cascade = CascadeType.ALL)
    private List<Meeting> meetings;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    private List<MeetingParticipant> meetingParticipans;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<UserSessions> userSessions;



    public User() {
    }

    // constructor
    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
    }

    // getters and setters
}
