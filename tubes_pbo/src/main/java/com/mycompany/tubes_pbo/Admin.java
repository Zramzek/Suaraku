/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tubes_pbo;

/**
 *
 * @author ACER
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.UUID;

public class Admin implements Loginable, ErrorHandler {
    protected String idAdmin;
    protected String username;
    protected String password;
    protected String otp;

    // Constructor
    public Admin(String idAdmin, String username, String password) {
        this.idAdmin = idAdmin;
        this.username = username;
        this.password = password;
    }

    // Metode untuk mem-ban user
    public void banUser(User user) {
        System.out.println("User " + user.getUsername() + " has been banned.");
    }

    // Menambahkan feedback baru
    public void addFeedback(Feedback feedback) {
        feedback.showFeedback();
    }

    // Memperbarui feedback
    public void updateFeedback(Feedback feedback) {
        System.out.println("Feedback updated: " + feedback);
    }

    // Menghapus feedback berdasarkan ID
    public void deleteFeedback(String idFeedback) {
        System.out.println("Feedback with ID " + idFeedback + " has been deleted.");
    }

    // Generate OTP dengan UUID
    public String generateOTP() {
        this.otp = UUID.randomUUID().toString().substring(0, 6);
        System.out.println("Generated OTP: " + otp); // Log OTP for testing purposes
        return otp;
    }

    // Verifikasi input OTP
    public boolean verifyOtpInput(String otpInput) {
        return otpInput.equals(this.otp);
    }

    @Override
    public void Login(String input) {
        System.out.println("Admin " + username + " logged in with: " + input);
    }

    @Override
    public void handleError(String errorMessage) {
        System.err.println("Admin Error: " + errorMessage);
    }

    // Tampilkan UI Login Admin
    public void showLoginUI() {
        JFrame frame = new JFrame("Admin Login");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new GridBagLayout());

        JLabel usernameLabel = new JLabel("Username:");
        JTextField usernameField = new JTextField(15);

        JLabel passwordLabel = new JLabel("Password:");
        JPasswordField passwordField = new JPasswordField(15);

        JButton loginButton = new JButton("Login");
        JLabel messageLabel = new JLabel("", SwingConstants.CENTER);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String inputUsername = usernameField.getText();
                String inputPassword = new String(passwordField.getPassword());

                if (username.equals(inputUsername) && password.equals(inputPassword)) {
                    messageLabel.setText("Login successful!");
                    messageLabel.setForeground(Color.GREEN);
                    frame.dispose();
                    showOtpVerificationUI();
                } else {
                    messageLabel.setText("Invalid username or password.");
                    messageLabel.setForeground(Color.RED);
                }
            }
        });

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        gbc.gridx = 0;
        gbc.gridy = 0;
        frame.add(usernameLabel, gbc);

        gbc.gridx = 1;
        frame.add(usernameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        frame.add(passwordLabel, gbc);

        gbc.gridx = 1;
        frame.add(passwordField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        frame.add(loginButton, gbc);

        gbc.gridy = 3;
        frame.add(messageLabel, gbc);

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    // Tampilkan UI Verifikasi OTP
    private void showOtpVerificationUI() {
        JFrame frame = new JFrame("OTP Verification");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);
        frame.setLayout(new GridBagLayout());

        JLabel otpLabel = new JLabel("Enter OTP:");
        JTextField otpField = new JTextField(10);
        JButton verifyButton = new JButton("Verify");

        JLabel messageLabel = new JLabel("", SwingConstants.CENTER);

        generateOTP(); // Generate OTP saat UI ditampilkan

        verifyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String inputOtp = otpField.getText();
                if (verifyOtpInput(inputOtp)) {
                    messageLabel.setText("OTP verified successfully!");
                    messageLabel.setForeground(Color.GREEN);
                    frame.dispose();
                    showAdminDashboard();
                } else {
                    messageLabel.setText("Invalid OTP.");
                    messageLabel.setForeground(Color.RED);
                }
            }
        });

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        gbc.gridx = 0;
        gbc.gridy = 0;
        frame.add(otpLabel, gbc);

        gbc.gridx = 1;
        frame.add(otpField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        frame.add(verifyButton, gbc);

        gbc.gridy = 2;
        frame.add(messageLabel, gbc);

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    // Tampilkan Dashboard Admin
    public void showAdminDashboard() {
        JFrame dashboard = new JFrame("Admin Dashboard");
        dashboard.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        dashboard.setSize(500, 400);
        dashboard.setLayout(new FlowLayout());

        JButton manageUsersButton = new JButton("Manage Users");
        JButton feedbackButton = new JButton("Feedback");
        JButton logoutButton = new JButton("Logout");

        manageUsersButton.addActionListener(e -> JOptionPane.showMessageDialog(dashboard, "Manage Users clicked!"));
        feedbackButton.addActionListener(e -> JOptionPane.showMessageDialog(dashboard, "Feedback clicked!"));
        logoutButton.addActionListener(e -> {
            JOptionPane.showMessageDialog(dashboard, "Logged out!");
            dashboard.dispose();
            showLoginUI();
        });

        dashboard.add(manageUsersButton);
        dashboard.add(feedbackButton);
        dashboard.add(logoutButton);

        dashboard.setLocationRelativeTo(null);
        dashboard.setVisible(true);
    }
}
