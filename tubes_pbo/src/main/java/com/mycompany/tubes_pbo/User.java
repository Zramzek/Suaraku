/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tubes_pbo;

/**
 *
 * @author ACER
 */
import java.util.ArrayList;
import java.util.List;

public class User implements ErrorHandler {
    protected String idUser;
    protected String username;
    protected String password;
    protected int usia;
    private List<Report> listReports;

    public User(String idUser, String username, String password, int usia) {
        this.idUser = idUser;
        this.username = username;
        this.password = password;
        this.usia = usia;
        this.listReports = new ArrayList<>();
    }

    public String getUsername() {
        return username;
    }

    public void addReport(Report report) {
        listReports.add(report);
    }

    public void editData(String newUsername, int newUsia) {
        this.username = newUsername;
        this.usia = newUsia;
    }

    public void buatKomentar(Komentar komentar) {
        System.out.println("User " + username + " created a comment: " + komentar);
    }

    public void showListLaporan() {
        for (Report report : listReports) {
            report.showReport();
        }
    }

    public void beriNilaiFeedback(Feedback feedback, String nilai) {
        System.out.println("Feedback rated: " + nilai);
    }

    @Override
    public void handleError(String errorMessage) {
        System.err.println("User Error: " + errorMessage);
    }
}
