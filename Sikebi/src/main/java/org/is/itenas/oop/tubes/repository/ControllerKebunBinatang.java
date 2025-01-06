/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.is.itenas.oop.tubes.repository;

/**
 *
 * @author Rizky
 */


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.itenas.oop.tugasbesar.model.Hewan;
import org.itenas.oop.tugasbesar.model.Tiket;
import org.itenas.oop.tugasbesar.utils.ConnectionManager;

public class ControllerKebunBinatang {
    private ConnectionManager conMan = new ConnectionManager();
    private Connection con = conMan.logOn();

    public boolean tambahHewan(String nama, String jenis, int umur) {
        String query = "INSERT INTO hewan (nama, jenis, umur) VALUES ('" + nama + "', '" + jenis + "', " + umur + ")";
        try {
            Statement stm = con.createStatement();
            stm.executeUpdate(query);
            return true;
        } catch (SQLException ex) {
            System.out.println(ex.toString());
            return false;
        }
    }

    public List<Hewan> tampilkanHewan() {
        List<Hewan> listHewan = new ArrayList<>();
        try {
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM hewan");
            while (rs.next()) {
                Hewan hewan = new Hewan();
                hewan.setIdHewan(rs.getInt("id_hewan"));
                hewan.setNama(rs.getString("nama"));
                hewan.setJenis(rs.getString("jenis"));
                hewan.setUmur(rs.getInt("umur"));
                listHewan.add(hewan);
            }
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
        return listHewan;
    }

    public boolean jualTiket(String namaPengunjung, int jumlah, double hargaPerTiket) {
        double totalHarga = jumlah * hargaPerTiket;
        String query = "INSERT INTO tiket (nama_pengunjung, jumlah, total_harga) VALUES ('" + namaPengunjung + "', " + jumlah + ", " + totalHarga + ")";
        try {
            Statement stm = con.createStatement();
            stm.executeUpdate(query);
            return true;
        } catch (SQLException ex) {
            System.out.println(ex.toString());
            return false;
        }
    }

    public List<Tiket> tampilkanTiket() {
        List<Tiket> listTiket = new ArrayList<>();
        try {
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM tiket");
            while (rs.next()) {
                Tiket tiket = new Tiket();
                tiket.setIdTiket(rs.getInt("id_tiket"));
                tiket.setNamaPengunjung(rs.getString("nama_pengunjung"));
                tiket.setJumlah(rs.getInt("jumlah"));
                tiket.setTotalHarga(rs.getDouble("total_harga"));
                listTiket.add(tiket);
            }
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
        return listTiket;
    }

    public boolean hapusHewan(int idHewan) {
        String query = "DELETE FROM hewan WHERE id_hewan = " + idHewan;
        try {
            Statement stm = con.createStatement();
            int rows = stm.executeUpdate(query);
            return rows > 0;
        } catch (SQLException ex) {
            System.out.println(ex.toString());
            return false;
        }
    }
}
