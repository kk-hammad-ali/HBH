package core;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author KK
 */
public class ConectionC {
    String DB_URL  = "jdbc:mysql://localhost/hbh";
    String user = "root";
    String pass = "whisper";
    
    public ResultSet result(String query) throws SQLException{
        Connection conn = DriverManager.getConnection(DB_URL, user, pass);
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        return rs;
    }
    public void insert(String query)throws SQLException{
        Connection conn = DriverManager.getConnection(DB_URL, user, pass);
        Statement statement = conn.createStatement();
        statement.execute(query);
    }
}