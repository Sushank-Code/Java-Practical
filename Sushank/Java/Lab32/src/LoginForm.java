import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.*;

public class LoginForm extends JFrame {
    JTextField usernameTextField;
    JPasswordField passwordField;

    public LoginForm() {
        setTitle("Login Form");
        setSize(400, 250);
        setLayout(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setBounds(50, 50, 100, 25);
        add(usernameLabel);

        usernameTextField = new JTextField();
        usernameTextField.setBounds(160, 50, 170, 25);
        add(usernameTextField);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(50, 90, 100, 25);
        add(passwordLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(160, 90, 170, 25);
        add(passwordField);

        JButton loginButton = new JButton("Login");
        loginButton.setBounds(150, 140, 100, 30);
        add(loginButton);

        loginButton.addActionListener(e -> login());
    }

    void login() {
        String username = usernameTextField.getText();
        String password = new String(passwordField.getPassword());

        if (username.equals("") || password.equals("")) {
            JOptionPane.showMessageDialog(this, "Please enter username and password.");
            return;
        }

        try {
            Connection connection = DBConnection.getConnection();
            String sql = "SELECT * FROM students WHERE username = ? AND password = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, username);
            statement.setString(2, password);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                JOptionPane.showMessageDialog(this, "Login successful.");
                new DisplayData().setVisible(true);
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Invalid username or password.");
            }

            resultSet.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }
    }
}
