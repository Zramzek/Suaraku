/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tubes_pbo;

/**
 *
 * @author ACER
 */
import java.time.LocalDateTime;
import java.util.List;
import java.util.ArrayList;

public class Report implements ErrorHandler {
    protected String idReport;
    protected String idUser;
    protected LocalDateTime waktuLapor;
    protected String status;
    protected Kategori kategori;
    private List<Feedback> listFeedbacks;
    private List<Komentar> listKomentars;

    public Report(String idReport, String idUser, LocalDateTime waktuLapor, String status, Kategori kategori) {
        this.idReport = idReport;
        this.idUser = idUser;
        this.waktuLapor = waktuLapor;
        this.status = status;
        this.kategori = kategori;
        this.listFeedbacks = new ArrayList<>();
        this.listKomentars = new ArrayList<>();
    }

    public void showReport() {
        System.out.println("Report ID: " + idReport);
        System.out.println("User ID: " + idUser);
        System.out.println("Report Time: " + waktuLapor);
        System.out.println("Status: " + status);
        System.out.println("Category: " + kategori.getNamaKategori());
    }

    public void addFeedback(Feedback feedback) {
        listFeedbacks.add(feedback);
    }

    public void addKomentar(Komentar komentar) {
        listKomentars.add(komentar);
    }

    @Override
    public void handleError(String errorMessage) {
        System.err.println("Report Error: " + errorMessage);
    }
}

