package ui;

import javax.swing.*;
import java.awt.*;

public class AdminLoginPanel extends JPanel {

    public AdminLoginPanel(JFrame frame) {
        setLayout(new GridLayout(3, 2, 5, 5));
        add(new JLabel("Admin ID:"));
        add(new JTextField());

        add(new JLabel("Password:"));
        add(new JPasswordField());

        add(new JButton("Back"));
        add(new JButton("Login"));
    }
}

