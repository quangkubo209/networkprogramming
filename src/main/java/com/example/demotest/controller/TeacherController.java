package com.example.demotest.controller;

import com.example.demotest.model.User;
import com.example.demotest.request.*;
import com.example.demotest.response.*;
import com.example.demotest.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/teacher")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @MessageMapping("/view-schedule")
    @SendTo("/topic/meetings")
    public ViewScheduleResponse viewSchedule(ViewScheduleRequest request) {
        return teacherService.viewSchedule(request);
    }

    @MessageMapping("/declare-slots")
    @SendTo("/topic/meetings")
    public DeclareSlotsResponse declareSlots(DeclareSlotsRequest request) {
        return teacherService.declareSlots(request);
    }


    @MessageMapping("/edit-meeting")
    @SendTo("/topic/meetings")
    public EditMeetingResponse editMeeting(EditMeetingRequest request) {
        return teacherService.editMeeting(request);
    }

    @MessageMapping("/view-history-schedule")
    @SendTo("/topic/meetings")
    public ViewHistoryScheduleResponse viewHistorySchedule(ViewHistoryScheduleRequest request) {
        return teacherService.viewHistorySchedule(request);
    }
}
