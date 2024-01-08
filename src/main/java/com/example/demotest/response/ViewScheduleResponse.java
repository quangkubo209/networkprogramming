package com.example.demotest.response;

import java.util.List;

public class ViewScheduleResponse {
    private String code;

    public Metadata getMetadata() {
        return metadata;
    }

    public void setMetadata(Metadata metadata) {
        this.metadata = metadata;
    }

    public List<ScheduledMeeting> getLists() {
        return lists;
    }

    public void setLists(List<ScheduledMeeting> lists) {
        this.lists = lists;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    private List<ScheduledMeeting> lists;
    private Metadata metadata;

    // Getters and setters
}