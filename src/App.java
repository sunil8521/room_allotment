import db.MySQLConnection;
import com.formdev.flatlaf.FlatLightLaf;
import org.mindrot.jbcrypt.BCrypt; // For hashing the password


import javax.swing.*;

// import ui.AdminLoginPanel;
// import ui.StudentLoginPanel;
import ui.LoginSelectionPanel;

public class App {
    public static void main(String[] args) throws Exception {
        MySQLConnection.buildConnection();
        if (MySQLConnection.connection == null) {
            System.err.println("App closed due to DB connection failure.");
            System.exit(0);
        }



        UIManager.setLookAndFeel(new FlatLightLaf());

        SwingUtilities.invokeLater(() -> {
            
            JFrame frame = new JFrame("Login Portal");
            
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(600, 600);
            frame.setLocationRelativeTo(null);


            frame.setContentPane(new LoginSelectionPanel(frame));
            frame.revalidate();
            frame.repaint();
            frame.setVisible(true);


            
        });
    
    }
}
