/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.io.Serializable;

/**
 *
 * @author nguye
 */
public class Attendance implements Serializable{
    private String attendanceId, studentId, classId, dateAttendance;
    private boolean status;

    public Attendance() {
    }

    public Attendance(String attendanceId, String studentId, String classId, String dateAttendance, boolean status) {
        this.attendanceId = attendanceId;
        this.studentId = studentId;
        this.classId = classId;
        this.dateAttendance = dateAttendance;
        this.status = status;
    }

    public String getAttendanceId() {
        return attendanceId;
    }

    public void setAttendanceId(String attendanceId) {
        this.attendanceId = attendanceId;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }

    public String getDateAttendance() {
        return dateAttendance;
    }

    public void setDateAttendance(String dateAttendance) {
        this.dateAttendance = dateAttendance;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
