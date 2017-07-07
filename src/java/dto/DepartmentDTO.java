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
public class DepartmentDTO implements Serializable{
    private int departmentId;
    private String Name;

    public DepartmentDTO() {
    }

    public DepartmentDTO(int departmentId, String Name) {
        this.departmentId = departmentId;
        this.Name = Name;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }
    
    
    
}
