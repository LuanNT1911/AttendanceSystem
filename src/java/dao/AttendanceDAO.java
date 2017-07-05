/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dbo.MyConnection;
import dto.Attendance;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Shou
 */
public class AttendanceDAO implements Serializable{
    public boolean insertAttendance(Attendance attendance) 
             throws ClassNotFoundException, SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        try {
            con = MyConnection.getMyConnection();
            if (con != null) {
                String sql = "Insert into Attendance(studentId, classId, DateAttendanced, status)"
                        + " Values(?,?,?,?)";
                stm = con.prepareStatement(sql);   
                stm.setString(1, attendance.getStudentId());
                stm.setString(2, attendance.getClassId());
                stm.setString(3, attendance.getDateAttendance());
                stm.setBoolean(4, attendance.isStatus());
                
                int row = stm.executeUpdate();
                if(row > 0) {
                    return true;
                }
            } 
        } catch (Exception e) {
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return false;
    }
    
    public boolean deleteAttendance(String attendanceId) throws SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        try {
            con = MyConnection.getMyConnection();
            if (con != null) {
                String sql = "Delete from Attendance where attendanceId = ?";
                stm = con.prepareStatement(sql);
                stm.setString(1, attendanceId);
                int row = stm.executeUpdate();
                if (row > 0) {
                    return true;
                }
            }
        } catch (Exception e) {
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return false;
    }
    
    public List<Attendance> getAll() throws SQLException {
        List<Attendance> list = new ArrayList<Attendance>();
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        Attendance att;
        try {
            con = MyConnection.getMyConnection();
            if (con != null) {
                String sql = "Select * from Attendance";
                stm = con.prepareStatement(sql);
                rs = stm.executeQuery();
                while (rs.next()) {
                    String attendanceId = rs.getString("attendanceId");
                    String studentId = rs.getString("studentId");
                    String classId = rs.getString("classId");
                    String dateAttendance = rs.getString("DateAttendanced");
                    Boolean status = rs.getBoolean("Status");
                    att = new Attendance(attendanceId, studentId, classId, 
                            dateAttendance, status);
                    list.add(att);
                }
            }
        } catch (Exception e) {
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return list;
    }
}
