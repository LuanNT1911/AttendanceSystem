/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dbo.MyConnection;
import dto.Course;
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
public class CourseDAO implements Serializable {

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

    public boolean insertCourse(String courseId, String name, String description, String term) throws ClassNotFoundException, SQLException {
        try {
            con = MyConnection.getMyConnection();
            if (con != null) {
                String sql = "insert into Course(courseId, Name, Description, Term) values(?,?,?,?)";
                pts = con.prepareStatement(sql);
                pts.setString(1, courseId);
                pts.setString(2, name);
                pts.setString(3, description);
                pts.setString(4, term);
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

    public boolean deleteCourse(String courseId) throws ClassNotFoundException, SQLException {
        try {
            con = MyConnection.getMyConnection();
            if (con != null) {
                String sql = "delete from Course where courseId = ?";
                pts = con.prepareStatement(sql);
                pts.setString(1, courseId);
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

    public List<Course> getAllCourse() throws ClassNotFoundException, SQLException {
        List<Course> list = new ArrayList<>();
        try {
            if (con != null) {
                String sql = "select * from Course";
                pts = con.prepareStatement(sql);
                rs = pts.executeQuery();
                if (rs.next()) {
                    String courseId = rs.getString("courseId");
                    String description = rs.getString("Description");
                    String name = rs.getString("Name");
                    String term = rs.getString("Term");
                    Course course = new Course(courseId, name, description, term);
                    list.add(course);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return list;
    }

    public boolean updateCourse(String courseId, String name, String description, String term) throws ClassNotFoundException, SQLException {
        try {
            if (con != null) {
                String sql = "update Course set Name = ?, Description = ?, Term = ? where courseId = ?";
                pts = con.prepareStatement(sql);
                pts.setString(1, name);
                pts.setString(2, description);
                pts.setString(3, term);
                pts.setString(4, courseId);
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
