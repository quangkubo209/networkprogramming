package com.example.demotest.model;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Table(name = "meeting_participant")
public class MeetingParticipant {

    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "meeting_id")
    private Meeting meeting;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Long student_id;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public Long getStudent_id() {
        return student_id;
    }

    public Meeting getMeeting() {
        return meeting;
    }

    public void setMeeting(Meeting meeting) {
        this.meeting = meeting;
    }

    public void setStudent_id(Long student_id) {
        this.student_id = student_id;
    }

    // getters and setters
}
