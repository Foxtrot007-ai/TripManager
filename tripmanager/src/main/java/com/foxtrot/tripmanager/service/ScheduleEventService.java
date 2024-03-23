package com.foxtrot.tripmanager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foxtrot.tripmanager.domain.Event;
import com.foxtrot.tripmanager.domain.Schedule;
import com.foxtrot.tripmanager.repository.EventRepository;
import com.foxtrot.tripmanager.repository.ScheduleRepository;

@Service
public class ScheduleEventService {
    @Autowired
    private ScheduleRepository shedules;

    @Autowired
    private EventRepository events;

    public List<Schedule> listAllSchedules(){
        return shedules.findAll();
    }

    public void saveSchedule(Schedule std){
        shedules.save(std);
    }

    public Schedule getSchedule(long id){
        return shedules.findById(id).get();
    }

    public void deleteSchedule(long id){
        shedules.deleteById(id);
        events.deleteAllByScheduleID(id);
    }

    public List<Event> listAllEventForSchedule(long id){
        return events.findAllByScheduleID(id);
    }

    public void saveEvent(Event std){
        events.save(std);
    }

    public Event getEvent(long id){
        return events.findById(id).get();
    }

    public void deleteEvent(long id){
        events.deleteById(id);
    }
}
