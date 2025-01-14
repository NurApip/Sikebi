/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itenas.zoo.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.itenas.zoo.model.Tiket;
import org.itenas.zoo.services.CrudService;
import org.itenas.zoo.utils.ConnectionManager;

/**
 *
 * @author HP
 */
public class TiketCrudServiceDbImpl implements CrudService {
    private final ConnectionManager connectionManager;

    // Konstruktor untuk inisialisasi ConnectionManager
    public TiketCrudServiceDbImpl(ConnectionManager connectionManager) {
        this.connectionManager = connectionManager;
    }

    @Override
    public void create(Tiket tiket) {
        String query = "INSERT INTO tiket (id, nama_acara, harga, tanggal, kategori, zona) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection connection = connectionManager.connectDb();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, tiket.getId());
            statement.setString(2, tiket.getNamaAcara());
            statement.setDouble(3, tiket.getHarga());
            statement.setString(4, tiket.getTanggal());
            statement.setString(5, tiket.getKategori());
            statement.setString(6, tiket.getZona());
            statement.executeUpdate();
            System.out.println("Data tiket berhasil ditambahkan.");
        } catch (SQLException e) {
            System.err.println("Error saat menambahkan data tiket: " + e.getMessage());
        }
    }

    @Override
    public Tiket findOne(String id) {
        Tiket tiket = null;
        String query = "SELECT * FROM tiket WHERE id = ?";
        try (Connection connection = connectionManager.connectDb();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    tiket = new Tiket(
                            resultSet.getString("id"),
                            resultSet.getString("nama_acara"),
                            resultSet.getDouble("harga"),
                            resultSet.getString("tanggal"),
                            resultSet.getString("kategori"),
                            resultSet.getString("zona")
                    );
                }
            }
        } catch (SQLException e) {
            System.err.println("Error saat mencari data tiket: " + e.getMessage());
        }
        return tiket;
    }

    @Override
    public List<Tiket> findAll() {
        List<Tiket> tiketList = new ArrayList<>();
        String query = "SELECT * FROM tiket";
        try (Connection connection = connectionManager.connectDb();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                Tiket tiket = new Tiket(
                        resultSet.getString("id"),
                        resultSet.getString("nama_acara"),
                        resultSet.getDouble("harga"),
                        resultSet.getString("tanggal"),
                        resultSet.getString("kategori"),
                        resultSet.getString("zona")
                );
                tiketList.add(tiket);
            }
        } catch (SQLException e) {
            System.err.println("Error saat mengambil data tiket: " + e.getMessage());
        }
        return tiketList;
    }

    @Override
    public void update(String id, Tiket tiket) {
        String query = "UPDATE tiket SET nama_acara = ?, harga = ?, tanggal = ?, kategori = ?, zona = ? WHERE id = ?";
        try (Connection connection = connectionManager.connectDb();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, tiket.getNamaAcara());
            statement.setDouble(2, tiket.getHarga());
            statement.setString(3, tiket.getTanggal());
            statement.setString(4, tiket.getKategori());
            statement.setString(5, tiket.getZona());
            statement.setString(6, id);
            statement.executeUpdate();
            System.out.println("Data tiket berhasil diperbarui.");
        } catch (SQLException e) {
            System.err.println("Error saat memperbarui data tiket: " + e.getMessage());
        }
    }

    @Override
    public boolean delete(String id) {
        String query = "DELETE FROM tiket WHERE id = ?";
        try (Connection connection = connectionManager.connectDb();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, id);
            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error saat menghapus data tiket: " + e.getMessage());
            return false;
        }
    }

    @Override
    public void create(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(String id, Object object) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
