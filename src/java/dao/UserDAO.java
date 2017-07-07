/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dbo.MyConnection;
import dto.UserDTO;
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
public class UserDAO implements Serializable{
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

    public boolean insertUser(String userId, String password, String roleId) throws ClassNotFoundException, SQLException {
        try {
            con = MyConnection.getMyConnection();
            if (con != null) {
                String sql = "insert into Users(userId, password, roleId) values(?,?,?)";
                pts = con.prepareStatement(sql);
                pts.setString(1, userId);
                pts.setString(2, password);
                pts.setString(3, roleId);
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

    public boolean deleteUser(String userId) throws ClassNotFoundException, SQLException {
        try {
            con = MyConnection.getMyConnection();
            if (con != null) {
                String sql = "delete from Users where userId = ?";
                pts = con.prepareStatement(sql);
                pts.setString(1, userId);
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

    public List<UserDTO> getAllCourse() throws ClassNotFoundException, SQLException {
        List<UserDTO> list = new ArrayList<>();
        try {
            if (con != null) {
                String sql = "select * from Users";
                pts = con.prepareStatement(sql);
                rs = pts.executeQuery();
                if (rs.next()) {
                    String userId = rs.getString("userId");
                    String roleId = rs.getString("roleId");
                    UserDTO user = new UserDTO(userId, roleId);
                    list.add(user);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return list;
    }

    public boolean updateUser(String userId, String password, String roleId) throws ClassNotFoundException, SQLException {
        try {
            if (con != null) {
                String sql = "update Users set password = ?, roleId = ? where userId = ?";
                pts = con.prepareStatement(sql);
                pts.setString(1, password);
                pts.setString(2, roleId);
                pts.setString(3, userId);
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
