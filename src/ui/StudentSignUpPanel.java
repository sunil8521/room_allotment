package ui;

import javax.swing.*;
import java.awt.*;
import auth.Auth;
public class StudentSignUpPanel extends JPanel {

    private final JTextField fullNameField;
    private final JTextField rollNoField;
    private final JComboBox<String> genderCombo;
    private final JComboBox<String> branchCombo;
    private final JPasswordField passwordField;
    private final JButton signUpButton;
    private final JButton loginButton;

    public StudentSignUpPanel(JFrame frame) {

        
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        fullNameField = new JTextField(15);
        rollNoField = new JTextField(15);
        genderCombo = new JComboBox<>(new String[]{"Male", "Female", "Other"});
        branchCombo = new JComboBox<>(new String[]{"MCA", "BCA", "MSc", "BTech", "BSc"});
        passwordField = new JPasswordField(15);
        signUpButton = new JButton("Sign Up");
        loginButton = new JButton("Login");

        int row = 0;
        addRow(gbc, row++, "Full Name:", fullNameField);
        addRow(gbc, row++, "Roll No:", rollNoField);
        addRow(gbc, row++, "Gender:", genderCombo);
        addRow(gbc, row++, "Branch:", branchCombo);
        addRow(gbc, row++, "Password:", passwordField);

        gbc.gridx = 0;
        gbc.gridy = row;
        add(loginButton, gbc);

        gbc.gridx = 1;
        add(signUpButton, gbc);
        loginButton.addActionListener(e -> {
            frame.setContentPane(new StudentLoginPanel(frame));
            frame.revalidate();
            frame.repaint();
        });

        
        signUpButton.addActionListener(e -> {
            String fullName = getFullName();
            String rollNo = getRollNo();
            String gender = getGender();
            String branch = getBranch();
            String password = getPassword();
        
            // Basic validation
            if (fullName.isEmpty() || rollNo.isEmpty() || password.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please fill in all required fields!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        
            // Call the Auth.signUp method
            boolean success = Auth.signUp(fullName, rollNo, gender, branch, password);
        
            if (success) {
                JOptionPane.showMessageDialog(this, "Sign-up successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
                // Optionally redirect to login
                frame.setContentPane(new StudentLoginPanel(frame));
                frame.revalidate();
                frame.repaint();
            } else {
                JOptionPane.showMessageDialog(this, "Sign-up failed! Try again.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        

    }

    private void addRow(GridBagConstraints gbc, int row, String labelText, JComponent input) {
        gbc.gridx = 0;
        gbc.gridy = row;
        add(new JLabel(labelText), gbc);

        gbc.gridx = 1;
        add(input, gbc);
    }

    // Getters for input data and buttons
    public String getFullName() {
        return fullNameField.getText();
    }

    public String getRollNo() {
        return rollNoField.getText();
    }

    public String getGender() {
        return (String) genderCombo.getSelectedItem();
    }

    public String getBranch() {
        return (String) branchCombo.getSelectedItem();
    }

    public String getPassword() {
        return new String(passwordField.getPassword());
    }

    public JButton getSignUpButton() {
        return signUpButton;
    }

    public JButton getBackButton() {
        return backButton;
    }
}
