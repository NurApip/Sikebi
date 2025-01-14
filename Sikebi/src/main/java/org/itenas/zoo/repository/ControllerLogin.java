/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itenas.zoo.repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.itenas.zoo.utils.ConnectionManager;

/**
 *
 * @author HP
 */
public class ControllerLogin {
    private ConnectionManager conMan;
    private Connection conn;
    Statement stmt;
    ResultSet rs;
    public int Login(String user, String pwd){
        int stat = 0;
        conMan= new ConnectionManager();
        conn = conMan.logOn();
        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM user where Username = '"
                    + user +"' and Password ='"+ pwd + "'");
            while (rs.next()){
                if (user.equals(rs.getString("Username"))
                        && pwd.equals(rs.getString("Password"))){
                    stat = 1;
               }else{
                    stat = 0;
                   }
            }
            return stat;
        } catch (SQLException ex) {
            return stat;
        }
    }
    
    public int register(String user,String pwd){
        int stat = 0;
        String query = "INSERT INTO user VALUES ("+"'"+ user +"',"+"'" + pwd +"');";
        conMan = new ConnectionManager();
        conn = conMan.logOn();
        try {
            stmt = conn.createStatement();
            stmt.executeUpdate(query);
            conMan.logOff();
        } catch (SQLException ex) {
            System.out.println("error; " + ex.getMessage());
        }
        
        return stat;
    }
}
