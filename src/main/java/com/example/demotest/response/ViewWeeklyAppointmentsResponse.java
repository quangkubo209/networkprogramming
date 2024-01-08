package com.example.demotest.response;

import java.util.List;

// Response
public class ViewWeeklyAppointmentsResponse {
    private String code;
    private List<Appointment> lists;

    public List<Appointment> getLists() {
        return lists;
    }

    public void setLists(List<Appointment> lists) {
        this.lists = lists;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Metadata getMetadata() {
        return metadata;
    }

    public void setMetadata(Metadata metadata) {
        this.metadata = metadata;
    }

    private Metadata metadata;

    // Getters and setters
}


