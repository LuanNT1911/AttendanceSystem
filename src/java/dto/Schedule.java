/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.io.Serializable;
import java.sql.Time;

/**
 *
 * @author nguye
 */
public class Schedule implements Serializable{
    private String scheduleId, name, day;
    private Time startTime, endTime;

    public Schedule() {
    }

    public Schedule(String scheduleId, String name, String day, Time startTime, Time endTime) {
        this.scheduleId = scheduleId;
        this.name = name;
        this.day = day;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public String getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(String scheduleId) {
        this.scheduleId = scheduleId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public Time getStartTime() {
        return startTime;
    }

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    public Time getEndTime() {
        return endTime;
    }

    public void setEndTime(Time endTime) {
        this.endTime = endTime;
    }
}
