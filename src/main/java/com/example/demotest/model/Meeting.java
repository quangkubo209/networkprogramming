package com.example.demotest.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "meeting")
public class Meeting {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "start_time")
    private LocalDateTime startTime;

    @Column(name = "end_time")
    private LocalDateTime endTime;

    @Column(name = "slot_type")
    private String slotType;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "slot_available")
    private int slotAvailable;

    @ManyToOne
    @JoinColumn(name = "teacher_id", nullable = false, referencedColumnName = "id")
    private User teacher;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "meeting")
    private MeetingMinutes meetingMinutes;

    @OneToMany(mappedBy = "meeting", cascade = CascadeType.ALL)
    private List<MeetingParticipant> meetingParticipants;




    private LocalDate date;



    // getters and setters
}
