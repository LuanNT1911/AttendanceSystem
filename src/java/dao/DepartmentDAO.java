/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dbo.MyConnection;
import dto.DepartmentDTO;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author nguye
 */
public class DepartmentDAO implements Serializable{
    private Connection con;
    private PreparedStatement pts;
    private ResultSet rs;

    public void closeConnection() {
        try {
            if (rs != null) {
                rs.close();
            }
            if (pts != null) {
                pts.close();
            }
            if (con != null) {
                con.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean insertDepartment(String departmentId, String name) throws ClassNotFoundException, SQLException {
        try {
            con = MyConnection.getMyConnection();
            if (con != null) {
                String sql = "insert into Department(departmentId, Name) values(?,?)";
                pts = con.prepareStatement(sql);
                pts.setString(1, departmentId);
                pts.setString(2, name);
                int check = pts.executeUpdate();
                if (check > 0) {
                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return false;
    }

    public boolean deleteDepartment(String departmentId) throws ClassNotFoundException, SQLException {
        try {
            con = MyConnection.getMyConnection();
            if (con != null) {
                String sql = "delete from Department where departmentId = ?";
                pts = con.prepareStatement(sql);
                pts.setString(1, departmentId);
                int check = pts.executeUpdate();
                if (check > 0) {
                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return false;
    }

    public List<DepartmentDTO> getAllDepartment() throws ClassNotFoundException, SQLException {
        List<DepartmentDTO> list = new ArrayList<>();
        try {
            if (con != null) {
                String sql = "select * from Department";
                pts = con.prepareStatement(sql);
                rs = pts.executeQuery();
                if (rs.next()) {
                    String departmentId = rs.getString("departmentId");
                    String name = rs.getString("Name");
                    DepartmentDTO department = new DepartmentDTO(departmentId, name);
                    list.add(department);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return list;
    }

    public boolean updateDepartment(String departmentId, String name) throws ClassNotFoundException, SQLException {
        try {
            if (con != null) {
                String sql = "update Department set Name = ? where departmentId = ?";
                pts = con.prepareStatement(sql);
                pts.setString(1, name);
                pts.setString(2, departmentId);
                int check = pts.executeUpdate();
                if (check > 0) {
                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return false;
    }
}
