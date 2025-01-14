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
import java.util.Scanner;
import org.itenas.zoo.model.Hewan;
import org.itenas.zoo.utils.ConnectionManager;

/**
 *
 * @author HP
 */
public class ControllerHewan {
    Scanner sc = new Scanner(System.in);
    ConnectionManager conMan = new ConnectionManager();
    Connection con = conMan.logOn();

    // Create: Tambah data Hewan
    public boolean insertHewan(String nama, String spesies, int umur) {
        String query = "INSERT INTO hewan (nama, spesies, umur) VALUES ('" + nama + "', '" + spesies + "', " + umur + ")";
        try {
            Statement stm = con.createStatement();
            stm.executeUpdate(query);
            return true;
        } catch (SQLException ex) {
            System.out.println(ex.toString());
            return false;
        }
    }

    // Read: Tampilkan semua data Hewan
    public List<Hewan> showHewan() {
        List<Hewan> listHewan = new ArrayList<>();
        String query = "SELECT * FROM hewan";
        try {
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(query);
            while (rs.next()) {
                Hewan hewan = new Hewan(
                    rs.getInt("id"),
                    rs.getString("nama"),
                    rs.getString("spesies"),
                    rs.getInt("umur")
                );
                listHewan.add(hewan);
            }
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
        return listHewan;
    }

    // Update: Ubah data Hewan berdasarkan ID
    public boolean updateHewan(String newNama, String newSpesies, int newUmur, int id) {
        String query = "UPDATE hewan SET nama = '" + newNama + "', spesies = '" + newSpesies + "', umur = " + newUmur + " WHERE id = " + id;
        try {
            Statement stm = con.createStatement();
            stm.executeUpdate(query);
            return true;
        } catch (SQLException ex) {
            System.out.println(ex.toString());
            return false;
        }
    }

    // Delete: Hapus data Hewan berdasarkan ID
    public boolean deleteHewan(int id) {
        String query = "DELETE FROM hewan WHERE id = " + id;
        try {
            Statement stm = con.createStatement();
            int rows = stm.executeUpdate(query);
            return rows > 0; // Mengembalikan true jika ada baris yang dihapus
        } catch (SQLException ex) {
            System.out.println(ex.toString());
            return false;
        }
    }

    // Search: Cari Hewan berdasarkan nama
    public List<Hewan> searchHewan(String nama) {
        List<Hewan> listHewan = new ArrayList<>();
        String query = "SELECT * FROM hewan WHERE nama = '" + nama + "'";
        try {
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(query);
            while (rs.next()) {
                Hewan hewan = new Hewan(
                    rs.getInt("id"),
                    rs.getString("nama"),
                    rs.getString("spesies"),
                    rs.getInt("umur")
                );
                listHewan.add(hewan);
            }
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
        return listHewan;
    }

    // Sort: Urutkan Hewan berdasarkan umur (ASC)
    public List<Hewan> sortHewanByUmurAsc() {
        List<Hewan> listHewan = new ArrayList<>();
        String query = "SELECT * FROM hewan ORDER BY umur ASC";
        try {
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(query);
            while (rs.next()) {
                Hewan hewan = new Hewan(
                    rs.getInt("id"),
                    rs.getString("nama"),
                    rs.getString("spesies"),
                    rs.getInt("umur")
                );
                listHewan.add(hewan);
            }
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
        return listHewan;
    }

    // Sort: Urutkan Hewan berdasarkan umur (DESC)
    public List<Hewan> sortHewanByUmurDesc() {
        List<Hewan> listHewan = new ArrayList<>();
        String query = "SELECT * FROM hewan ORDER BY umur DESC";
        try {
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(query);
            while (rs.next()) {
                Hewan hewan = new Hewan(
                    rs.getInt("id"),
                    rs.getString("nama"),
                    rs.getString("spesies"),
                    rs.getInt("umur")
                );
                listHewan.add(hewan);
            }
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
        return listHewan;
    }
}