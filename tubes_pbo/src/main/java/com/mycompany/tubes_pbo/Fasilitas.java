/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tubes_pbo;

/**
 *
 * @author ACER
 */
public class Fasilitas extends Kategori {
    private String kerusakan;

    public Fasilitas(String idKategori, String namaFasilitas, String kerusakan) {
        super(idKategori, namaFasilitas);
        this.kerusakan = kerusakan;
    }

    @Override
    public void showInfo() {
        System.out.println("Facility Category ID: " + idKategori);
        System.out.println("Facility Name: " + namaKategori);
        System.out.println("Damage Description: " + kerusakan);
    }
}

