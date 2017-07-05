/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dbo.MyConnection;
import dto.Schedule;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Shou
 */
public class ScheduleDAO implements Serializable{
    public boolean insertSchedule(Schedule schedule) 
             throws ClassNotFoundException, SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        try {
            con = MyConnection.getMyConnection();
            if (con != null) {
                String sql = "Insert into Schedule(Name, Day, StartTime, EndTime)"
                        + " Values(?,?,?,?)";
                stm = con.prepareStatement(sql);   
                stm.setString(1, schedule.getName());
                stm.setString(2, schedule.getDay());
                stm.setTime(3, schedule.getStartTime());
                stm.setTime(4, schedule.getEndTime());
                
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
    
    public boolean deleteSchedule(String scheduleId) throws SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        try {
            con = MyConnection.getMyConnection();
            if (con != null) {
                String sql = "Delete from Schedule where scheduleId = ?";
                stm = con.prepareStatement(sql);
                stm.setString(1, scheduleId);
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
    
    public List<Schedule> getAll() throws SQLException {
        List<Schedule> list = new ArrayList<Schedule>();
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        Schedule schedule;
        try {
            con = MyConnection.getMyConnection();
            if (con != null) {
                String sql = "Select * from Schedule";
                stm = con.prepareStatement(sql);
                rs = stm.executeQuery();
                while (rs.next()) {
                    String scheduleId = rs.getString("scheduleId");
                    String Name = rs.getString("Name");
                    String Day = rs.getString("Day");
                    Time StartTime = rs.getTime("StartTime");
                    Time EndTime = rs.getTime("EndTime");
                    schedule = new Schedule(scheduleId, Name, Day, 
                            StartTime, EndTime);
                    list.add(schedule);
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
