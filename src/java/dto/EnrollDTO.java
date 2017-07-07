/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 *
 * @author Shou
 */
public class EnrollDTO implements Serializable{
    private int enrollId, studentId, classId, Year;
    private String Term, DateEnrolled;

    public EnrollDTO() {
    }

    public EnrollDTO(int enrollId, int studentId, int classId, int Year, String Term, String DateEnrolled) {
        this.enrollId = enrollId;
        this.studentId = studentId;
        this.classId = classId;
        this.Year = Year;
        this.Term = Term;
        this.DateEnrolled = DateEnrolled;
    }

    public int getEnrollId() {
        return enrollId;
    }

    public void setEnrollId(int enrollId) {
        this.enrollId = enrollId;
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

    public int getYear() {
        return Year;
    }

    public void setYear(int Year) {
        this.Year = Year;
    }

    public String getTerm() {
        return Term;
    }

    public void setTerm(String Term) {
        this.Term = Term;
    }

    public String getDateEnrolled() {
        return DateEnrolled;
    }

    public void setDateEnrolled(String DateEnrolled) {
        this.DateEnrolled = DateEnrolled;
    }
    
}
