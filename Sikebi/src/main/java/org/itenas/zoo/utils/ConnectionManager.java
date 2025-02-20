/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itenas.zoo.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author HP
 */
public class ConnectionManager {
    private Connection con;
    private String url = "jdbc:mysql://localhost:3306/kebunbinatang";
    private String Driver = "com.mysql.cj.jdbc.Driver";
    private String Username = "root";
    private String Password = "1234";
    
    public Connection logOn(){
        if(con == null){
            try{
                Class.forName(Driver).newInstance();
                con = DriverManager.getConnection(url,Username,Password);
            } catch (Exception ex){
                ex.printStackTrace();
            }
        }
        return con;
    }
    
    public Connection logOff(){
        try{
            con.close();
        } catch (SQLException ex){
            System.out.println(ex.getMessage());
        }
        return con;
    }
}