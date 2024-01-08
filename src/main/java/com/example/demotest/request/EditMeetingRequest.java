package com.example.demotest.request;

public class EditMeetingRequest {
    private String action;
    private String userId;
    private MeetingInformation meetingInformation;

    public MeetingInformation getMeetingInformation() {
        return meetingInformation;
    }

    public void setMeetingInformation(MeetingInformation meetingInformation) {
        this.meetingInformation = meetingInformation;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }
// Getters and setters
}