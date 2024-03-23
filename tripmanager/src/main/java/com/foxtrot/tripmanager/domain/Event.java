package com.foxtrot.tripmanager.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Event {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)

    @Column(name="id")
    private Long id;
    @Column(name="type")
    private String type;
    @Column(name="begin")
    private String begin;
    @Column(name="end")
    private String end;
    @Column(name="info")
    private String info;
    @Column(name="scheduleID")
    private long scheduleID;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBegin() {
        return begin;
    }

    public void setBegin(String begin) {
        this.begin = begin;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Event() {
        super();
    }

    public Event(Long id, String type, String begin, String end, String info, long scheduleID) {
        super();
        this.id = id;
        this.type = type;
        this.begin = begin;
        this.end = end;
        this.info = info;
        this.scheduleID = scheduleID;
    }

    public long getScheduleID() {
        return scheduleID;
    }

    public void setScheduleID(long scheduleID) {
        this.scheduleID = scheduleID;
    }
    
   
}
