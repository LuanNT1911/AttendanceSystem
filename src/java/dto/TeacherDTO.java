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
public class TeacherDTO implements Serializable{
    private int teacherId, deparmentId, Phone;
    private String LastName, FirstName, Email;

    public TeacherDTO() {
    }

    public TeacherDTO(int teacherId, int deparmentId, int Phone, String LastName, String FirstName, String Email) {
        this.teacherId = teacherId;
        this.deparmentId = deparmentId;
        this.Phone = Phone;
        this.LastName = LastName;
        this.FirstName = FirstName;
        this.Email = Email;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    public int getDeparmentId() {
        return deparmentId;
    }

    public void setDeparmentId(int deparmentId) {
        this.deparmentId = deparmentId;
    }

    public int getPhone() {
        return Phone;
    }

    public void setPhone(int Phone) {
        this.Phone = Phone;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String LastName) {
        this.LastName = LastName;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }
    
    
}
