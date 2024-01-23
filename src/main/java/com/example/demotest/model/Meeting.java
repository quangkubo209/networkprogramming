package com.example.demotest.model;

import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "meeting")
public class Meeting {

    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private Long teacherId;

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

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "meeting")
    private MeetingMinutes meetingMinutes;

    @OneToMany(mappedBy = "meeting", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MeetingParticipant> meetingParticipants;

    public List<MeetingParticipant> getMeetingParticipants() {
        return meetingParticipants;
    }

    // Phương thức setter cho meetingParticipants
    public void setMeetingParticipants(List<MeetingParticipant> meetingParticipants) {
        this.meetingParticipants = meetingParticipants;
    }


    public MeetingMinutes getMeetingMinutes() {
        return meetingMinutes;
    }

    public void setMeetingMinutes(MeetingMinutes meetingMinutes) {
        this.meetingMinutes = meetingMinutes;
    }

    private LocalDate date;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }


    public Long getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Long teacherId) {
        this.teacherId = teacherId;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public String getSlotType() {
        return slotType;
    }

    public void setSlotType(String slotType) {
        this.slotType = slotType;
    }

    public int getSlotAvailable() {
        return slotAvailable;
    }

    public void setSlotAvailable(int slotAvailable) {
        this.slotAvailable = slotAvailable;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    // getters and setters
}
