/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.tubes_pbo;
import java.time.LocalDateTime;
/**
 *
 * @author ACER
 */
public class Tubes_pbo {
    public static void main(String[] args) {
        // Create Admin
        Admin admin = new Admin("A001", "admin1", "pass123");
        admin.showLoginUI();

        // Create Users
        User user1 = new User("U001", "john_doe", "password123", 25);
        User user2 = new User("U002", "jane_doe", "password456", 28);

        // Admin logs in
        admin.Login("Admin Portal");

        // Create Categories through concrete classes
        Fasilitas fasilitas = new Fasilitas("CAT001", "Air Conditioning", "Leaking water");
        Aspirasi aspirasi = new Aspirasi("CAT002", "Employee Feedback", "Improve workplace ergonomics");

        // Create Reports
        Report report1 = new Report("R001", user1.getUsername(), LocalDateTime.now(), "Pending", fasilitas);
        Report report2 = new Report("R002", user2.getUsername(), LocalDateTime.now(), "Resolved", aspirasi);

        // User adds reports
        user1.addReport(report1);
        user2.addReport(report2);

        // Create and add Feedback
        Feedback feedback1 = new Feedback("F001", "A001", "R001", "Good job resolving this issue", "report1_attachment.pdf");
        admin.addFeedback(feedback1);
        report1.addFeedback(feedback1);

        // User creates a comment
        Komentar komentar1 = new Komentar("K001", "Please address this quickly.", "comment1_attachment.png");
        user1.buatKomentar(komentar1);
        report1.addKomentar(komentar1);

        // Show report details
        System.out.println("\n--- Report Details ---");
        report1.showReport();

        // Show all user's reports
        System.out.println("\n--- User's Reports ---");
        user1.showListLaporan();

        // Display facility and aspiration information
        System.out.println("\n--- Facility Info ---");
        fasilitas.showInfo();

        System.out.println("\n--- Aspiration Info ---");
        aspirasi.showInfo();

        // Admin bans a user
        admin.banUser(user2);
    }
}
