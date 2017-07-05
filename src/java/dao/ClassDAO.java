/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dbo.MyConnection;
import dto.Class;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Shou
 */
public class ClassDAO implements Serializable{
    public boolean insertClass(Class cl) 
             throws ClassNotFoundException, SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        try {
            con = MyConnection.getMyConnection();
            if (con != null) {
                String sql = "Insert into Class(Name, couresId, scheduleId, teacherId, room)"
                        + " Values(?,?,?,?,?)";
                stm = con.prepareStatement(sql);   
                stm.setString(1, cl.getName());
                stm.setString(2, cl.getCourseId());
                stm.setString(3, cl.getScheduleId());
                stm.setString(4, cl.getTeacherId());
                stm.setString(5, cl.getRoom());
                

                
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
    

    public boolean deleteClass(String classId) throws SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        try {
            con = MyConnection.getMyConnection();
            if (con != null) {
                String sql = "Delete from Class where classId = ?";
                stm = con.prepareStatement(sql);
                stm.setString(1, classId);
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
    
    public List<Class> getAll() throws SQLException {
        List<Class> list = new ArrayList<Class>();
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        Class cl;
        try {
            con = MyConnection.getMyConnection();
            if (con != null) {
                String sql = "Select * from Class";
                stm = con.prepareStatement(sql);
                rs = stm.executeQuery();
                while (rs.next()) {
                    String classId = rs.getString("classId");
                    String name = rs.getString("name");
                    String couresId = rs.getString("courseId");
                    String scheduleId = rs.getString("scheduleId");
                    String teacherId = rs.getString("teacherId");
                    String room = rs.getString("room");
                    cl = new Class(classId, name, couresId, 
                            scheduleId, teacherId, room);
                    list.add(cl);
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
