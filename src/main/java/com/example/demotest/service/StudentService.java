package com.example.demotest.service;

import com.example.demotest.model.Meeting;
import com.example.demotest.model.User;
import com.example.demotest.repository.MeetingRepository;
import com.example.demotest.repository.UserRepository;
import com.example.demotest.request.BookMeetingRequest;
import com.example.demotest.request.CancelMeetingRequest;
import com.example.demotest.request.ViewAvailableTimeSlotsRequest;
import com.example.demotest.request.ViewWeeklyAppointmentsRequest;
import com.example.demotest.response.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private MeetingRepository meetingRepository;

    public ViewAvailableTimeSlotsResponse viewAvailableTimeSlots(ViewAvailableTimeSlotsRequest request) {
        int page = Integer.parseInt(request.getPage()) - 1; // Giảm đi 1 vì PageRequest bắt đầu từ 0
        int size = Integer.parseInt(request.getSize());

        Page<Meeting> meetingPage = meetingRepository.findAvailableTimeSlots(
                request.getSearch(), (Pageable) PageRequest.of(page, size));

        List<TimeSlot> timeSlots = meetingPage.getContent().stream()
                .map(this::mapToTimeSlot)
                .collect(Collectors.toList());

        ViewAvailableTimeSlotsResponse response = new ViewAvailableTimeSlotsResponse();
        response.setCode("VIEW_AVAILABLE_TIME_SLOTS_OK");
        response.setLists(timeSlots);
        response.setMetadata(createMetadata(meetingPage));

        return response;
    }

    public ViewWeeklyAppointmentsResponse viewWeeklyAppointments(ViewWeeklyAppointmentsRequest request) {
        int page = Integer.parseInt(request.getPage()) - 1; // Giảm đi 1 vì PageRequest bắt đầu từ 0
        int size = Integer.parseInt(request.getSize());

        Page<Meeting> meetingPage = meetingRepository.findWeeklyAppointments(
                request.getStartTime(), request.getEndTime(), (Pageable) PageRequest.of(page, size));

        List<TimeSlot> timeSlots = meetingPage.getContent().stream()
                .map(this::mapToTimeSlot)
                .collect(Collectors.toList());

        ViewWeeklyAppointmentsResponse response = new ViewWeeklyAppointmentsResponse();
        response.setCode("VIEW_WEEKLY_APPOINTMENTS_OK");
        response.setLists(timeSlots);
        response.setMetadata(createMetadata(meetingPage));

        return response;
    }


    private TimeSlot mapToTimeSlot(Meeting meeting) {
        TimeSlot timeSlot = new TimeSlot();
        timeSlot.setMeetingId(meeting.getId());
        timeSlot.setStartTime(meeting.getStartTime());
        timeSlot.setEndTime(meeting.getEndTime());
        timeSlot.setSlotType(meeting.getSlotType());
        timeSlot.setRemainingSlot(meeting.getSlotAvailable());
        return timeSlot;
    }

    private Metadata createMetadata(Page<Meeting> meetingPage) {
        Metadata metadata = new Metadata();
        metadata.setHasNextPage(meetingPage.hasNext());
        metadata.setHasPreviousPage(meetingPage.hasPrevious());
        metadata.setTotalPage(meetingPage.getTotalPages());
        metadata.setTotalRow((int) meetingPage.getTotalElements());
        return metadata;
    }

    public BookMeetingResponse bookMeeting(BookMeetingRequest request) {
        // Xử lý yêu cầu đặt cuộc hẹn và trả về phản hồi
        // (Thêm logic xử lý đặt cuộc hẹn ở đây)

        BookMeetingResponse response = new BookMeetingResponse();
        response.setCode("BOOK_MEETING_CREATED");
        return response;
    }

    public CancelMeetingResponse cancelMeeting(CancelMeetingRequest request) {
        // Xử lý yêu cầu hủy cuộc hẹn và trả về phản hồi
        // (Thêm logic xử lý hủy cuộc hẹn ở đây)

        CancelMeetingResponse response = new CancelMeetingResponse();
        response.setCode("CANCEL_MEETING_OK");
        return response;
    }
}
