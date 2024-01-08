package com.example.demotest.response;

import java.util.List;

public class MeetingDetails {
    private String meetingId;
    private String startTime;
    private String endTime;
    private List<StudentDetails> listStudent;
    private String meetingMinutes;

    // Getters and setters

    public String getMeetingMinutes() {
        return meetingMinutes;
    }

    public void setMeetingMinutes(String meetingMinutes) {
        this.meetingMinutes = meetingMinutes;
    }

    public List<StudentDetails> getListStudent() {
        return listStudent;
    }

    public void setListStudent(List<StudentDetails> listStudent) {
        this.listStudent = listStudent;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getMeetingId() {
        return meetingId;
    }

    public void setMeetingId(String meetingId) {
        this.meetingId = meetingId;
    }
}
