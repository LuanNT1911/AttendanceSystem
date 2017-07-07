/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dbo.MyConnection;
import dto.EnrollDTO;
import java.io.Serializable;
import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author nguye
 */
public class EnrollDAO implements Serializable {

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

    public boolean insertEnroll(String enrollId, String year, String term, String studentId, String classId) throws ClassNotFoundException, SQLException {
        try {
            con = MyConnection.getMyConnection();
            if (con != null) {
                String sql = "insert into Enroll(enrollId, Year, Term, DateEnrolled, studentId, classId) values(?,?,?,?,?,?)";
                pts = con.prepareStatement(sql);
                pts.setString(1, enrollId);
                pts.setString(2, year);
                pts.setString(3, term);
                Date now = new Date();
                Timestamp addDate = new Timestamp(now.getTime());
                pts.setTimestamp(4, addDate);
                pts.setString(5, studentId);
                pts.setString(6, classId);
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


    public List<EnrollDTO> getAllDepartment() throws ClassNotFoundException, SQLException {
        List<EnrollDTO> list = new ArrayList<>();
        try {
            if (con != null) {
                String sql = "select * from Department";
                pts = con.prepareStatement(sql);
                rs = pts.executeQuery();
                if (rs.next()) {
                    String enrollId = rs.getString("enrollId");
                    int year = rs.getInt("Year");
                    String term = rs.getString("Term");
                    Timestamp date = rs.getTimestamp("DateEnrolled");
                    String studentId = rs.getString("studentId");
                    String classId = rs.getString("classId");
                    EnrollDTO enroll = new EnrollDTO(enrollId, term, studentId, classId, year, date);
                    list.add(enroll);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return list;
    }

}
