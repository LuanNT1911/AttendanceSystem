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
public class ManagerDTO implements Serializable{
    private int managerId, departmentId, Phone;
    private String LastName, FirstName;

    public ManagerDTO() {
    }

    public ManagerDTO(int managerId, int departmentId, int Phone, String LastName, String FirstName) {
        this.managerId = managerId;
        this.departmentId = departmentId;
        this.Phone = Phone;
        this.LastName = LastName;
        this.FirstName = FirstName;
    }

    public int getManagerId() {
        return managerId;
    }

    public void setManagerId(int managerId) {
        this.managerId = managerId;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
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

    
}
