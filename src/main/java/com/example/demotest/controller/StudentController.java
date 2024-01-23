package com.example.demotest.controller;
import com.example.demotest.request.BookMeetingRequest;
import com.example.demotest.request.CancelMeetingRequest;
import com.example.demotest.request.ViewAvailableTimeSlotsRequest;
import com.example.demotest.request.ViewWeeklyAppointmentsRequest;
import com.example.demotest.response.*;
import com.example.demotest.service.StudentService;
import com.example.demotest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.messaging.simp.SimpMessagingTemplate;

import java.util.*;
import java.util.List;

@RestController
public class StudentController {
    @Autowired
    private StudentService studentService;
    @MessageMapping("/view-available-time-slots")
    @SendTo("/topic/meetings")
    public ViewAvailableTimeSlotsResponse viewAvailableTimeSlots(ViewAvailableTimeSlotsRequest request) {
        return studentService.viewAvailableTimeSlots(request);
    }

    @MessageMapping("/view-weekly-appointments")
    @SendTo("/topic/meetings")
    public ViewWeeklyAppointmentsResponse viewWeeklyAppointments(ViewWeeklyAppointmentsRequest request) {
        return studentService.viewWeeklyAppointments(request);
    }

    @MessageMapping("/book-meeting")
    @SendTo("/topic/meetings")
    public BookMeetingResponse bookMeeting(BookMeetingRequest request) {
        return studentService.bookMeeting(request);
    }

    @MessageMapping("/cancel-meeting")
    @SendTo("/topic/meetings")
    public CancelMeetingResponse cancelMeeting(CancelMeetingRequest request) {
        return studentService.cancelMeeting(request);
    }
}