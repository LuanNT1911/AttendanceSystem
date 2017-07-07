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
public class RoleDTO implements Serializable{
    private int roleId;
    private String RoleName;

    public RoleDTO() {
    }

    public RoleDTO(int roleId, String RoleName) {
        this.roleId = roleId;
        this.RoleName = RoleName;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return RoleName;
    }

    public void setRoleName(String RoleName) {
        this.RoleName = RoleName;
    }
    
    
}
