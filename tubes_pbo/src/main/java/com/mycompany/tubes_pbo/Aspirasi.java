/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tubes_pbo;

/**
 *
 * @author ACER
 */
public class Aspirasi extends Kategori {
    private String isiAspirasi;

    public Aspirasi(String idKategori, String namaKategori, String isiAspirasi) {
        super(idKategori, namaKategori);
        this.isiAspirasi = isiAspirasi;
    }

    @Override
    public void showInfo() {
        System.out.println("Aspiration Category ID: " + idKategori);
        System.out.println("Aspiration: " + isiAspirasi);
    }
}