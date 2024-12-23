/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tubes_pbo;

/**
 *
 * @author ACER
 */
public class Feedback implements ErrorHandler {
    public String idFeedback;
    public String idAdmin;
    public String idReport;
    public String isiFeedback;
    public String lampiran;

    public Feedback(String idFeedback, String idAdmin, String idReport, String isiFeedback, String lampiran) {
        this.idFeedback = idFeedback;
        this.idAdmin = idAdmin;
        this.idReport = idReport;
        this.isiFeedback = isiFeedback;
        this.lampiran = lampiran;
    }

    public void showFeedback() {
        System.out.println("Feedback ID: " + idFeedback);
        System.out.println("Admin ID: " + idAdmin);
        System.out.println("Report ID: " + idReport);
        System.out.println("Feedback Content: " + isiFeedback);
        System.out.println("Attachment: " + lampiran);
    }

    @Override
    public void handleError(String errorMessage) {
        System.err.println("Feedback Error: " + errorMessage);
    }
}
