package com.example.demotest.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "meeting_participant")
@Getter
@Setter
public class MeetingParticipant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "meeting_id")
    private Meeting meeting;

    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false, referencedColumnName = "id")
    private User student;



}
