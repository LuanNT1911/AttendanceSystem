/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dbo.MyConnection;
import dto.AttendanceDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Shou
 */
public class AttendanceDAO {
    public static int insert(AttendanceDTO att){  
        int status=0;  
        try{  
            Connection con=MyConnection.getMyConnection();  
            PreparedStatement ps=con.prepareStatement(  
                         "insert into Attendance(studentId,classId,Status,DateAttendanced) values (?,?,?,?)");  
            ps.setInt(1,att.getStudentId());  
            ps.setInt(2,att.getClassId());  
            ps.setBoolean(3,att.getStatus());  
            ps.setString(4,att.getDateAttendanced());  
              
            status=ps.executeUpdate();  
              
            con.close();  
        }catch(Exception ex){
            ex.printStackTrace();}  
          
        return status;  
    }
     
    public static int update(AttendanceDTO att){  
        int status=0;  
        try{  
            Connection con=MyConnection.getMyConnection();  
            PreparedStatement ps=con.prepareStatement(  
                         "update Attendance set studentId=?,classId=?,Status=?,DateAttendanced=? where attendanceId=?");  
            ps.setInt(1,att.getStudentId());  
            ps.setInt(2,att.getClassId());  
            ps.setBoolean(3,att.getStatus());  
            ps.setString(4,att.getDateAttendanced());  
            ps.setInt(5,att.getAttendanceId());  
              
            status=ps.executeUpdate();  
              
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return status;  
    }
     
    public static int delete(int id){  
        int status=0;  
        try{  
            Connection con=MyConnection.getMyConnection();  
            PreparedStatement ps=con.prepareStatement("delete from Attendance where attendanceId=?");  
            ps.setInt(1,id);  
            status=ps.executeUpdate();
              
            con.close();  
        }catch(Exception e){e.printStackTrace();}  
          
        return status;  
    }
    
    public static AttendanceDTO getAttendanceById(int id){  
        AttendanceDTO att = new AttendanceDTO();  
          
        try{  
            Connection con=MyConnection.getMyConnection();  
            PreparedStatement ps=con.prepareStatement("select * from Attendance where attendanceId=?");  
            ps.setInt(1,id);  
            ResultSet rs=ps.executeQuery();  
            if(rs.next()){  
                att.setAttendanceId(rs.getInt(1));  
                att.setStudentId(rs.getInt(2));  
                att.setClassId(rs.getInt(3));  
                att.setStatus(rs.getBoolean(4));  
                att.setDateAttendanced(rs.getString(5));  
            }  
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return att;  
    }
    
    public static List<AttendanceDTO> getAllAttendance(){  
        List<AttendanceDTO> list = new ArrayList<AttendanceDTO>();  
          
        try{  
            Connection con=MyConnection.getMyConnection();  
            PreparedStatement ps=con.prepareStatement("select * from Attendance");  
            ResultSet rs=ps.executeQuery();  
            while(rs.next()){  
                AttendanceDTO att = new AttendanceDTO();  
                att.setAttendanceId(rs.getInt(1));  
                att.setStudentId(rs.getInt(2));  
                att.setClassId(rs.getInt(3));  
                att.setStatus(rs.getBoolean(4));  
                att.setDateAttendanced(rs.getString(5));  
                list.add(att);  
            }  
            con.close();  
        }catch(Exception e){e.printStackTrace();}  
          
        return list;  
    }
}
