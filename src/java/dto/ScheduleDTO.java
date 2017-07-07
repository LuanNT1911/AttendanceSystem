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
 * @author Shou
 */
public class ScheduleDTO implements Serializable{
    private int scheduleId;
    private String Name, Day, StartTime, EndTime;

    public ScheduleDTO() {
    }

    public ScheduleDTO(int scheduleId, String Name, String Day, String StartTime, String EndTime) {
        this.scheduleId = scheduleId;
        this.Name = Name;
        this.Day = Day;
        this.StartTime = StartTime;
        this.EndTime = EndTime;
    }

    public int getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(int scheduleId) {
        this.scheduleId = scheduleId;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getDay() {
        return Day;
    }

    public void setDay(String Day) {
        this.Day = Day;
    }

    public String getStartTime() {
        return StartTime;
    }

    public void setStartTime(String StartTime) {
        this.StartTime = StartTime;
    }

    public String getEndTime() {
        return EndTime;
    }

    public void setEndTime(String EndTime) {
        this.EndTime = EndTime;
    }
    
    
}
