import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.*;

public class RegisterForm extends JFrame {
    JTextField idTextField;
    JTextField usernameTextField;
    JPasswordField passwordField;
    JPasswordField confirmPasswordField;
    JRadioButton maleRadioButton;
    JRadioButton femaleRadioButton;
    JCheckBox bcaCheckBox;
    JCheckBox bbsCheckBox;
    JCheckBox csitCheckBox;
    JComboBox<String> countryComboBox;
    JTextArea addressTextArea;

    public RegisterForm() {
        setTitle("Register Form");
        setSize(500, 560);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel idLabel = new JLabel("ID:");
        idLabel.setBounds(40, 30, 120, 25);
        add(idLabel);

        idTextField = new JTextField();
        idTextField.setBounds(180, 30, 220, 25);
        add(idTextField);

        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setBounds(40, 70, 120, 25);
        add(usernameLabel);

        usernameTextField = new JTextField();
        usernameTextField.setBounds(180, 70, 220, 25);
        add(usernameTextField);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(40, 110, 120, 25);
        add(passwordLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(180, 110, 220, 25);
        add(passwordField);

        JLabel confirmPasswordLabel = new JLabel("Confirm Password:");
        confirmPasswordLabel.setBounds(40, 150, 130, 25);
        add(confirmPasswordLabel);

        confirmPasswordField = new JPasswordField();
        confirmPasswordField.setBounds(180, 150, 220, 25);
        add(confirmPasswordField);

        JLabel genderLabel = new JLabel("Gender:");
        genderLabel.setBounds(40, 190, 120, 25);
        add(genderLabel);

        maleRadioButton = new JRadioButton("Male");
        maleRadioButton.setBounds(180, 190, 80, 25);
        add(maleRadioButton);

        femaleRadioButton = new JRadioButton("Female");
        femaleRadioButton.setBounds(270, 190, 90, 25);
        add(femaleRadioButton);

        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(maleRadioButton);
        genderGroup.add(femaleRadioButton);

        JLabel courseLabel = new JLabel("Course:");
        courseLabel.setBounds(40, 230, 120, 25);
        add(courseLabel);

        bcaCheckBox = new JCheckBox("BCA");
        bcaCheckBox.setBounds(180, 230, 70, 25);
        add(bcaCheckBox);

        bbsCheckBox = new JCheckBox("BBS");
        bbsCheckBox.setBounds(250, 230, 70, 25);
        add(bbsCheckBox);

        csitCheckBox = new JCheckBox("CSIT");
        csitCheckBox.setBounds(320, 230, 80, 25);
        add(csitCheckBox);

        JLabel countryLabel = new JLabel("Country:");
        countryLabel.setBounds(40, 270, 120, 25);
        add(countryLabel);

        String[] countries = {"Nepal", "India", "China", "Japan"};
        countryComboBox = new JComboBox<>(countries);
        countryComboBox.setBounds(180, 270, 220, 25);
        add(countryComboBox);

        JLabel addressLabel = new JLabel("Address:");
        addressLabel.setBounds(40, 310, 120, 25);
        add(addressLabel);

        addressTextArea = new JTextArea();
        JScrollPane addressScrollPane = new JScrollPane(addressTextArea);
        addressScrollPane.setBounds(180, 310, 220, 80);
        add(addressScrollPane);

        JButton registerButton = new JButton("Register");
        registerButton.setBounds(140, 420, 100, 30);
        add(registerButton);

        JButton loginButton = new JButton("Login");
        loginButton.setBounds(260, 420, 100, 30);
        add(loginButton);

        registerButton.addActionListener(e -> registerStudent());
        loginButton.addActionListener(e -> new LoginForm().setVisible(true));
    }

    void registerStudent() {
        String id = idTextField.getText();
        String username = usernameTextField.getText();
        String password = new String(passwordField.getPassword());
        String confirmPassword = new String(confirmPasswordField.getPassword());
        String gender = getGender();
        String course = getCourse();
        String country = countryComboBox.getSelectedItem().toString();
        String address = addressTextArea.getText();

        if (id.equals("") || username.equals("") || password.equals("") || confirmPassword.equals("")
                || gender.equals("") || course.equals("") || address.equals("")) {
            JOptionPane.showMessageDialog(this, "Please fill all fields.");
            return;
        }

        if (!password.equals(confirmPassword)) {
            JOptionPane.showMessageDialog(this, "Password and confirm password must be same.");
            return;
        }

        try {
            Connection connection = DBConnection.getConnection();
            String sql = "INSERT INTO students VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setInt(1, Integer.parseInt(id));
            statement.setString(2, username);
            statement.setString(3, password);
            statement.setString(4, gender);
            statement.setString(5, course);
            statement.setString(6, country);
            statement.setString(7, address);

            statement.executeUpdate();
            statement.close();
            connection.close();

            JOptionPane.showMessageDialog(this, "Student registered successfully.");
            clearForm();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "ID must be a number.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }
    }

    String getGender() {
        if (maleRadioButton.isSelected()) {
            return "Male";
        }
        if (femaleRadioButton.isSelected()) {
            return "Female";
        }
        return "";
    }

    String getCourse() {
        String course = "";

        if (bcaCheckBox.isSelected()) {
            course = course + "BCA ";
        }
        if (bbsCheckBox.isSelected()) {
            course = course + "BBS ";
        }
        if (csitCheckBox.isSelected()) {
            course = course + "CSIT ";
        }

        return course.trim();
    }

    void clearForm() {
        idTextField.setText("");
        usernameTextField.setText("");
        passwordField.setText("");
        confirmPasswordField.setText("");
        maleRadioButton.setSelected(false);
        femaleRadioButton.setSelected(false);
        bcaCheckBox.setSelected(false);
        bbsCheckBox.setSelected(false);
        csitCheckBox.setSelected(false);
        countryComboBox.setSelectedIndex(0);
        addressTextArea.setText("");
    }
}
