package ui;

import javax.swing.*;
import java.awt.*;

public class LoginSelectionPanel extends JPanel {

    private final JButton studentLoginButton;
    private final JButton adminLoginButton;

    public LoginSelectionPanel(JFrame frame) {
        
        setLayout(new GridBagLayout());

        studentLoginButton = new JButton("Student Login");
        adminLoginButton = new JButton("Admin Login");

        studentLoginButton.setPreferredSize(new Dimension(200, 40));
        adminLoginButton.setPreferredSize(new Dimension(200, 40));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 0, 10, 0);
        gbc.gridx = 0;

        gbc.gridy = 0;
        add(studentLoginButton, gbc);

        gbc.gridy = 1;
        add(adminLoginButton, gbc);

        studentLoginButton.addActionListener(e -> {
            frame.setContentPane(new StudentLoginPanel(frame));
            frame.revalidate();
            frame.repaint();
        });

        adminLoginButton.addActionListener(e -> {
            frame.setContentPane(new AdminLoginPanel(frame));
            frame.revalidate();
            frame.repaint();
        });


    }

    public JButton getStudentLoginButton() {
        return studentLoginButton;
    }

    public JButton getAdminLoginButton() {
        return adminLoginButton;
    }
 
}
