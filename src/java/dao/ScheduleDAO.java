/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dbo.MyConnection;
import dto.ScheduleDTO;
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
    public boolean insertSchedule(ScheduleDTO schedule) 
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
                stm.setString(3, schedule.getStartTime());
                stm.setString(4, schedule.getEndTime());
                
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
    
    public static int update(ScheduleDTO sche){  
        int status=0;  
        try{  
            Connection con=MyConnection.getMyConnection();  
            PreparedStatement ps=con.prepareStatement(  
                         "update Schedule set Name=?,Day=?,StartTime=?,EndTime=? where scheduleId=?");  
            ps.setString(1,sche.getName());  
            ps.setString(2,sche.getDay());  
            ps.setString(3,sche.getStartTime());  
            ps.setString(4,sche.getEndTime());  
            ps.setInt(5,sche.getScheduleId());  
              
            status=ps.executeUpdate();  
              
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return status;  
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
    
    public static ScheduleDTO getScheduleById(int id){  
        ScheduleDTO sche = new ScheduleDTO();  
          
        try{  
            Connection con=MyConnection.getMyConnection();  
            PreparedStatement ps=con.prepareStatement("select * from Schedule where scheduleId=?");  
            ps.setInt(1,id);  
            ResultSet rs=ps.executeQuery();  
            if(rs.next()){  
                sche.setScheduleId(rs.getInt(1));  
                sche.setName(rs.getString(2));  
                sche.setDay(rs.getString(3));  
                sche.setStartTime(rs.getString(4));  
                sche.setEndTime(rs.getString(5));  
            }  
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return sche;  
    }
    
    public static List<ScheduleDTO> getAllSchedule(){  
        List<ScheduleDTO> list = new ArrayList<ScheduleDTO>();  
          
        try{  
            Connection con=MyConnection.getMyConnection();  
            PreparedStatement ps=con.prepareStatement("select * from Schedule");  
            ResultSet rs=ps.executeQuery();  
            while(rs.next()){  
                ScheduleDTO sche = new ScheduleDTO();  
                sche.setScheduleId(rs.getInt(1));  
                sche.setName(rs.getString(2));  
                sche.setDay(rs.getString(3));  
                sche.setStartTime(rs.getString(4));  
                sche.setEndTime(rs.getString(5));  
                list.add(sche);  
            }  
            con.close();  
        }
        catch(Exception e)
        {e.printStackTrace();
        }           
        return list;  
    }
}

