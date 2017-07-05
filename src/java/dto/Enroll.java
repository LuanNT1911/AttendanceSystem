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
 * @author nguye
 */
public class Enroll implements Serializable{
    private String enrollId, term, studentId, classId;
    private int year;
    private Timestamp dateEnrolled;

    public Enroll() {
    }

    public Enroll(String enrollId, String term, String studentId, String classId, int year, Timestamp dateEnrolled) {
        this.enrollId = enrollId;
        this.term = term;
        this.studentId = studentId;
        this.classId = classId;
        this.year = year;
        this.dateEnrolled = dateEnrolled;
    }

    

    public String getEnrollId() {
        return enrollId;
    }

    public void setEnrollId(String enrollId) {
        this.enrollId = enrollId;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
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

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Timestamp getDateEnrolled() {
        return dateEnrolled;
    }

    public void setDateEnrolled(Timestamp dateEnrolled) {
        this.dateEnrolled = dateEnrolled;
    }

   
    
}
