package com.foxtrot.tripmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.foxtrot.tripmanager.domain.Schedule;

public interface ScheduleRepository extends JpaRepository<Schedule,Long> {
    
}