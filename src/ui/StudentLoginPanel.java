package ui;

import javax.swing.*;
import java.awt.*;



public class StudentLoginPanel extends JPanel {

    private final JTextField rollNoField;
    private final JPasswordField passwordField;
    private final JButton loginButton;
    private final JButton backButton;
    private final JButton signUpButton;

    public StudentLoginPanel(JFrame frame) {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 8, 8, 8);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        rollNoField = new JTextField(18);
        passwordField = new JPasswordField(18);
        loginButton = new JButton("Login");
        backButton = new JButton("Back");
        signUpButton = new JButton("Sign Up");

        int row = 0;

        // Roll No
        gbc.gridx = 0;
        gbc.gridy = row;
        add(new JLabel("Roll No:"), gbc);
        gbc.gridx = 1;
        add(rollNoField, gbc);

        // Password
        gbc.gridy++;
        gbc.gridx = 0;
        add(new JLabel("Password:"), gbc);
        gbc.gridx = 1;
        add(passwordField, gbc);

        // Buttons Row
        gbc.gridy++;
        gbc.gridx = 0;
        add(backButton, gbc);
        gbc.gridx = 1;
        add(loginButton, gbc);

        // Sign Up Button
        gbc.gridy++;
        gbc.gridwidth = 2;
        gbc.gridx = 0;
        gbc.anchor = GridBagConstraints.CENTER;
        add(signUpButton, gbc);

        backButton.addActionListener(e -> {
            frame.setContentPane(new LoginSelectionPanel(frame));
            frame.revalidate();
            frame.repaint();
        });

        signUpButton.addActionListener(e -> {
            frame.setContentPane(new StudentSignUpPanel(frame));
            frame.revalidate();
            frame.repaint();
        });
        loginButton.addActionListener(e -> {
            String rollNo = getRollNo();
          
            String password = getPassword();
        
            // Basic validation
            if (rollNo.isEmpty() ||  password.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please fill in all required fields!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }


            
        });





    }

    // Getters for use in event handling
    public String getRollNo() {
        return rollNoField.getText();
    }

    public String getPassword() {
        return new String(passwordField.getPassword());
    }

    public JButton getLoginButton() {

        return loginButton;
    }

    public JButton getBackButton() {
        return backButton;
    }

    public JButton getSignUpButton() {
        return signUpButton;
    }
}
