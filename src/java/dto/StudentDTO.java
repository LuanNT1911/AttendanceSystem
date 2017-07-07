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
public class StudentDTO implements Serializable{
    private int studentId, Phone;
    private String LastName, FirstName, Email;

    public StudentDTO() {
    }

    public StudentDTO(int studentId, int Phone, String LastName, String FirstName, String Email) {
        this.studentId = studentId;
        this.Phone = Phone;
        this.LastName = LastName;
        this.FirstName = FirstName;
        this.Email = Email;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
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
