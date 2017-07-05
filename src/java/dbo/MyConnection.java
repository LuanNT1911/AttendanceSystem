/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbo;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;

/**
 *
 * @author nguye
 */
public class MyConnection {
    public static Connection getMyConnection(){
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection("jdbc:sqlserver://LUANNTSE61328; databaseName = Web-base; userName=sa; password=445861");
            return con;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
