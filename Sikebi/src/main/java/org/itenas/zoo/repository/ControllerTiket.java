/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itenas.zoo.repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.itenas.zoo.model.Tiket;
import org.itenas.zoo.utils.ConnectionManager;

/**
 *
 * @author HP
 */
public class ControllerTiket {
    private ConnectionManager conMan;
    private Connection conn;
    private Statement stmt;
    private ResultSet rs;

    // CREATE: Add a new ticket
    public int addTicket(int id, String namaAcara, double harga, String tanggal,String kategori, String zona) {
        int stat = 0;
        String query = "INSERT INTO TiketKebunBinatang (id, nama_acara, harga, tanggal, jumlah_tiket, kategori, zona) "
                + "VALUES ('" + id + "', '" + namaAcara + "', " + harga + ", '" + tanggal + "', '" + kategori + "', '" + zona + "');";
        conMan = new ConnectionManager();
        conn = conMan.logOn();
        try {
            stmt = conn.createStatement();
            stmt.executeUpdate(query);
            stat = 1; // 1 means ticket added successfully
            conMan.logOff();
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
        return stat;
    }

    
    public Tiket getTicket(String id) {
        Tiket ticket = null;
        conMan = new ConnectionManager();
        conn = conMan.logOn();
        try {
            Statement stm = conn.createStatement();
            rs = stm.executeQuery("SELECT * FROM TiketKebunBinatang WHERE id = '" + id + "'");
            if (rs.next()) {
                String namaAcara = rs.getString("nama_acara");
                double harga = rs.getDouble("harga");
                String tanggal = rs.getString("tanggal");
                String kategori = rs.getString("kategori");
                String zona = rs.getString("zona");
                ticket = new Tiket(id, namaAcara, harga, tanggal,kategori, zona);
            }
            conMan.logOff();
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
        return ticket;
    }

    // UPDATE: Update ticket details (e.g., update ticket price or quantity)
    public int updateTicket(int id, String namaAcara, double harga, String tanggal, String kategori, String zona) {
        int stat = 0;
        String query = "UPDATE TiketKebunBinatang SET "
                + "nama_acara = '" + namaAcara + "', "
                + "harga = " + harga + ", "
                + "tanggal = '" + tanggal + "', "
                + "kategori = '" + kategori + "', "
                + "zona = '" + zona + "' "
                + "WHERE id = '" + id + "'";
        conMan = new ConnectionManager();
        conn = conMan.logOn();
        try {
            stmt = conn.createStatement();
            stmt.executeUpdate(query);
            stat = 1; // 1 means ticket updated successfully
            conMan.logOff();
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
        return stat;
    }

    // DELETE: Delete a ticket by id
    public int deleteTicket(int id) {
        int stat = 0;
        String query = "DELETE FROM TiketKebunBinatang WHERE id = '" + id + "'";
        conMan = new ConnectionManager();
        conn = conMan.logOn();
        try {
            stmt = conn.createStatement();
            stmt.executeUpdate(query);
            stat = 1; // 1 means ticket deleted successfully
            conMan.logOff();
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
        return stat;
    }

    // READ ALL: Get all tickets
    public ResultSet getAllTickets() {
        conMan = new ConnectionManager();
        conn = conMan.logOn();
        try {
            Statement stm = conn.createStatement();
            rs = stm.executeQuery("SELECT * FROM TiketKebunBinatang");
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
        return rs;
    }
}
