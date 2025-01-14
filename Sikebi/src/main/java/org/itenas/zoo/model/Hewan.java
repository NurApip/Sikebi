/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itenas.zoo.model;

/**
 *
 * @author HP
 */
public class Hewan {
    private int id;
    private String nama;
    private String spesies;
    private int umur;

    // Constructor, Getter, dan Setter
    public Hewan(int id, String nama, String spesies, int umur) {
        this.id = id;
        this.nama = nama;
        this.spesies = spesies;
        this.umur = umur;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getSpesies() {
        return spesies;
    }

    public void setSpesies(String spesies) {
        this.spesies = spesies;
    }

    public int getUmur() {
        return umur;
    }

    public void setUmur(int umur) {
        this.umur = umur;
    }  
} 
