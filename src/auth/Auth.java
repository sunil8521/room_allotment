package auth;

import db.MySQLConnection;
// import org.mindrot.jbcrypt.BCrypt;
import java.sql.*;
import Models.User;

public class Auth {

    // Sign Up method with password hashing
    public static boolean signUp(String rollNo, String fullName, String gender, String branch, String password) {
        // Hash the password using BCrypt before saving
        // String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt());

        String query = "INSERT INTO Student (full_name, roll_no, gender, branch, password) VALUES (?, ?, ?, ?, ?)";
        Connection conn = MySQLConnection.connection; 
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, fullName);
            stmt.setString(2, rollNo);
            stmt.setString(3, gender);
            stmt.setString(4, branch);
            stmt.setString(5, password);
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Login method with roll_no and password verification
    public static User login(String rollNo, String password) {
        String query = "SELECT * FROM Student WHERE roll_no = ?";
        Connection conn = MySQLConnection.connection;
    
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, rollNo);
            ResultSet rs = stmt.executeQuery();
    
            if (rs.next()) {
                String storedPassword = rs.getString("password");  // Get the plain text password
    
                // Directly compare the entered password with the stored password (in plain text)
                if (password.equals(storedPassword)) {
                    // Password matches, create user object and return it
                    User user = new User();
                    user.setId(rs.getInt("id"));
                    user.setRollNo(rs.getString("roll_no"));
                    user.setFullName(rs.getString("full_name"));
                    user.setPassword(storedPassword);  // Store the plain text password (not recommended)
                    return user;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;  // Return null if login fails
    }
    
    // Optional: To check if a rollNo already exists (useful for validation during sign-up)
    public static boolean rollNoExists(String rollNo) {
        String query = "SELECT 1 FROM Student WHERE roll_no = ?";
        Connection conn = MySQLConnection.connection;

        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, rollNo);
            ResultSet rs = stmt.executeQuery();

            return rs.next(); // If the rollNo exists, return true
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
