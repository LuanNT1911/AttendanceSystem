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
public class CourseDTO implements Serializable{
    private int courseId;
    private String Name, Description, Term;

    public CourseDTO() {
    }

    public CourseDTO(int courseId, String Name, String Description, String Term) {
        this.courseId = courseId;
        this.Name = Name;
        this.Description = Description;
        this.Term = Term;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public String getTerm() {
        return Term;
    }

    public void setTerm(String Term) {
        this.Term = Term;
    }
    
    
}
