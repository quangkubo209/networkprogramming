package com.example.demotest.repository;

import com.example.demotest.model.Meeting;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.awt.print.Pageable;
import java.time.LocalDateTime;
import java.util.List;

public interface MeetingRepository extends JpaRepository<Meeting, Long> {

    @Query("SELECT m FROM Meeting m " +
            "WHERE m.teacher.fullname = :teacherName " +
            "AND m.startTime >= current_timestamp " +
            "ORDER BY m.createdAt ASC")
    Page<Meeting> findAvailableTimeSlots(
            @Param("teacherName") String teacherName,
            Pageable pageable);

    @Query("SELECT m FROM Meeting m " +
            "WHERE m.startTime >= :startTime " +
            "AND m.endTime <= :endTime " +
            "ORDER BY m.createdAt ASC")
    Page<Meeting> findWeeklyAppointments(
            @Param("startTime") LocalDateTime startTime,
            @Param("endTime") LocalDateTime endTime,
            Pageable pageable);


    @Query("SELECT m FROM Meeting m " +
            "JOIN m.teacher t " +
            "JOIN t.userSessions us " +
            "WHERE us.sessionKey = :session " +
            "ORDER BY m.createdAt ASC")
    Page<Meeting> findSchedule(@Param("session") String session, Pageable pageable);


@Query("SELECT m FROM Meeting m " +
        "JOIN m.teacher t " +
        "JOIN t.userSessions us " +
        "WHERE us.sessionKey = :session " +
        "AND m.slotType = :meetingType " +
        "AND m.endTime < CURRENT_TIMESTAMP " +
        "ORDER BY m.endTime DESC")
Page<Meeting> findHistorySchedule(
        @Param("session") String session,
        @Param("meetingType") String meetingType,
        Pageable pageable
);



}