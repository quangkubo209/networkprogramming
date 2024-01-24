package com.example.demotest.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "meeting_minutes")
public class MeetingMinutes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;



    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="meeting_id", referencedColumnName = "id")
    private Meeting meeting;

    private String content;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;



    // getters and setters
}
