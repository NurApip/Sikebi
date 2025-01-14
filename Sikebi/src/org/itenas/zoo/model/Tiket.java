/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itenas.zoo.model;

/**
 *
 * @author HP
 */
public class Tiket {

    private String id;             
    private String namaAcara;       
    private double harga;           
    private String tanggal;         
    private int jumlahTiket;        
    private String kategori;        
    private String zona;            

    // Constructor
    public Tiket(String kode_tiket, String namaAcara, double harga, String tanggal, 
                               int jumlahTiket, String kategori, String zona) {
        this.id = kode_tiket;
        this.namaAcara = namaAcara;
        this.harga = harga;
        this.tanggal = tanggal;
        this.jumlahTiket = jumlahTiket;
        this.kategori = kategori;
        this.zona = zona;
    }

    // Getters and Setter
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNamaAcara() {
        return namaAcara;
    }

    public void setNamaAcara(String namaAcara) {
        this.namaAcara = namaAcara;
    }

    public double getHarga() {
        return harga;
    }

    public void setHarga(double harga) {
        this.harga = harga;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public int getJumlahTiket() {
        return jumlahTiket;
    }

    public void setJumlahTiket(int jumlahTiket) {
        this.jumlahTiket = jumlahTiket;
    }

    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }

    public String getZona() {
        return zona;
    }

    public void setZona(String zona) {
        this.zona = zona;
    }
    
}
