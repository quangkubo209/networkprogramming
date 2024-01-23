package com.example.demotest.model;

import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "meeting_minutes")
public class MeetingMinutes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;



    @OneToOne
    @JoinColumn(name="meeting_id")
    private Long meeting_id;

    private String content;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }



    public void setContent(String content) {
        this.content = content;
    }

    public Long getMeeting_id() {
        return meeting_id;
    }

    public void setMeeting_id(Long meeting_id) {
        this.meeting_id = meeting_id;
    }


    // getters and setters
}
