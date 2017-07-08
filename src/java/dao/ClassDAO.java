/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dbo.MyConnection;
import dto.ClassDTO;
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
    public boolean insertClass(ClassDTO cl) 
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
                stm.setInt(2, cl.getCourseId());
                stm.setInt(3, cl.getScheduleId());
                stm.setInt(4, cl.getTeacherId());
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
    
    public static int update(ClassDTO cl){  
        int status=0;  
        try{  
            Connection con=MyConnection.getMyConnection();  
            PreparedStatement ps=con.prepareStatement(  
                         "update Schedule set Name=?,courseId=?,scheduleId=?,teacherId=?, room=? where classId=?");  
            ps.setString(1,cl.getName());  
            ps.setInt(2,cl.getCourseId());  
            ps.setInt(3,cl.getScheduleId());  
            ps.setInt(4,cl.getTeacherId());  
            ps.setString(4,cl.getRoom());  
            ps.setInt(5,cl.getClassId());  
              
            status=ps.executeUpdate();  
              
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return status;  
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
    
    public static ClassDTO getClassById(int id){  
        ClassDTO cl = new ClassDTO();  
          
        try{  
            Connection con=MyConnection.getMyConnection();  
            PreparedStatement ps=con.prepareStatement("select * from Class where classId=?");  
            ps.setInt(1,id);  
            ResultSet rs=ps.executeQuery();  
            if(rs.next()){  
                cl.setClassId(rs.getInt(1));  
                cl.setName(rs.getString(2));  
                cl.setCourseId(rs.getInt(3));  
                cl.setScheduleId(rs.getInt(4));  
                cl.setTeacherId(rs.getInt(5));  
                cl.setRoom(rs.getString(5));  
            }  
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return cl;  
    }
    
    public static List<ClassDTO> getAllClass(){  
        List<ClassDTO> list = new ArrayList<ClassDTO>();  
          
        try{  
            Connection con=MyConnection.getMyConnection();  
            PreparedStatement ps=con.prepareStatement("select * from Class");  
            ResultSet rs=ps.executeQuery();  
            while(rs.next()){  
                ClassDTO cl = new ClassDTO();  
                cl.setClassId(rs.getInt(1));  
                cl.setName(rs.getString(2));  
                cl.setCourseId(rs.getInt(3));  
                cl.setScheduleId(rs.getInt(4));  
                cl.setTeacherId(rs.getInt(5));  
                cl.setRoom(rs.getString(5));
                list.add(cl);  
            }  
            con.close();  
        }
        catch(Exception e)
        {e.printStackTrace();
        }           
        return list;  
    }
}
