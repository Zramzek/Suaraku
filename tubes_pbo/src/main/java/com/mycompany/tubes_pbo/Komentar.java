/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tubes_pbo;

/**
 *
 * @author ACER
 */
public class Komentar implements ErrorHandler {
    private String idKomentar;
    private String isiKomentar;
    private String lampiran;

    public Komentar(String idKomentar, String isiKomentar, String lampiran) {
        this.idKomentar = idKomentar;
        this.isiKomentar = isiKomentar;
        this.lampiran = lampiran;
    }

    public void showKomentar(User user) {
        System.out.println("Comment ID: " + idKomentar);
        System.out.println("User: " + user.getUsername());
        System.out.println("Comment: " + isiKomentar);
        System.out.println("Attachment: " + lampiran);
    }

    @Override
    public void handleError(String errorMessage) {
        System.err.println("Komentar Error: " + errorMessage);
    }
}
