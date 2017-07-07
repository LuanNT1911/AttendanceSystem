/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.io.Serializable;

/**
 *
 * @author Shou
 */
public class AttendanceDTO implements Serializable{
    private int attendanceId, studentId, classId;
    private String DateAttendanced;
    private Boolean Status;

    public AttendanceDTO() {
    }

    public AttendanceDTO(int attendanceId, int studentId, int classId, String DateAttendanced, Boolean Status) {
        this.attendanceId = attendanceId;
        this.studentId = studentId;
        this.classId = classId;
        this.DateAttendanced = DateAttendanced;
        this.Status = Status;
    }

    public int getAttendanceId() {
        return attendanceId;
    }

    public void setAttendanceId(int attendanceId) {
        this.attendanceId = attendanceId;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    public String getDateAttendanced() {
        return DateAttendanced;
    }

    public void setDateAttendanced(String DateAttendanced) {
        this.DateAttendanced = DateAttendanced;
    }

    public Boolean getStatus() {
        return Status;
    }

    public void setStatus(Boolean Status) {
        this.Status = Status;
    }
    
    
}
