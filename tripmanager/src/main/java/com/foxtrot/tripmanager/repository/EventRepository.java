package com.foxtrot.tripmanager.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.foxtrot.tripmanager.domain.Event;

public interface EventRepository extends JpaRepository<Event,Long> {
    List<Event> deleteAllByScheduleID(long scheduleID);
    List<Event> findAllByScheduleID(long scheduleID);
}
