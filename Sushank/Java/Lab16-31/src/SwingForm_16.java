import javax.swing.*;

public class SwingForm_16 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Student Form");
        frame.setSize(520, 620);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel titleLabel = new JLabel("Student Form");
        titleLabel.setBounds(190, 20, 150, 25);
        frame.add(titleLabel);

        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setBounds(50, 70, 100, 25);
        frame.add(nameLabel);

        JTextField nameTextField = new JTextField();
        nameTextField.setBounds(160, 70, 220, 25);
        frame.add(nameTextField);

        JLabel genderLabel = new JLabel("Gender:");
        genderLabel.setBounds(50, 115, 100, 25);
        frame.add(genderLabel);

        JRadioButton maleRadioButton = new JRadioButton("Male");
        maleRadioButton.setBounds(160, 115, 80, 25);
        frame.add(maleRadioButton);

        JRadioButton femaleRadioButton = new JRadioButton("Female");
        femaleRadioButton.setBounds(250, 115, 90, 25);
        frame.add(femaleRadioButton);

        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(maleRadioButton);
        genderGroup.add(femaleRadioButton);

        JLabel hobbyLabel = new JLabel("Hobbies:");
        hobbyLabel.setBounds(50, 160, 100, 25);
        frame.add(hobbyLabel);

        JCheckBox readingCheckBox = new JCheckBox("Reading");
        readingCheckBox.setBounds(160, 160, 90, 25);
        frame.add(readingCheckBox);

        JCheckBox musicCheckBox = new JCheckBox("Music");
        musicCheckBox.setBounds(260, 160, 80, 25);
        frame.add(musicCheckBox);

        JCheckBox sportsCheckBox = new JCheckBox("Sports");
        sportsCheckBox.setBounds(350, 160, 80, 25);
        frame.add(sportsCheckBox);

        JLabel courseLabel = new JLabel("Course:");
        courseLabel.setBounds(50, 205, 100, 25);
        frame.add(courseLabel);

        String[] courses = {"BCA", "BBS", "BIM", "CSIT"};
        JComboBox<String> courseComboBox = new JComboBox<>(courses);
        courseComboBox.setBounds(160, 205, 220, 25);
        frame.add(courseComboBox);

        JLabel addressLabel = new JLabel("Address:");
        addressLabel.setBounds(50, 250, 100, 25);
        frame.add(addressLabel);

        JTextArea addressTextArea = new JTextArea();
        JScrollPane addressScrollPane = new JScrollPane(addressTextArea);
        addressScrollPane.setBounds(160, 250, 220, 80);
        frame.add(addressScrollPane);

        JButton submitButton = new JButton("Submit");
        submitButton.setBounds(160, 355, 100, 30);
        frame.add(submitButton);

        JButton clearButton = new JButton("Clear");
        clearButton.setBounds(280, 355, 100, 30);
        frame.add(clearButton);

        JLabel resultLabel = new JLabel("Form details will be displayed here.");
        resultLabel.setBounds(50, 410, 420, 130);
        resultLabel.setVerticalAlignment(SwingConstants.TOP);
        frame.add(resultLabel);

        submitButton.addActionListener(e -> {
            String gender = "Not selected";
            if (maleRadioButton.isSelected()) {
                gender = "Male";
            } else if (femaleRadioButton.isSelected()) {
                gender = "Female";
            }

            String hobbies = "";
            if (readingCheckBox.isSelected()) {
                hobbies = hobbies + "Reading ";
            }
            if (musicCheckBox.isSelected()) {
                hobbies = hobbies + "Music ";
            }
            if (sportsCheckBox.isSelected()) {
                hobbies = hobbies + "Sports ";
            }
            if (hobbies.equals("")) {
                hobbies = "None";
            }

            String address = addressTextArea.getText().replace("\n", "<br>");

            resultLabel.setText("<html>"
                    + "Name: " + nameTextField.getText() + "<br>"
                    + "Gender: " + gender + "<br>"
                    + "Hobbies: " + hobbies + "<br>"
                    + "Course: " + courseComboBox.getSelectedItem() + "<br>"
                    + "Address: " + address
                    + "</html>");
        });

        clearButton.addActionListener(e -> {
            nameTextField.setText("");
            genderGroup.clearSelection();
            readingCheckBox.setSelected(false);
            musicCheckBox.setSelected(false);
            sportsCheckBox.setSelected(false);
            courseComboBox.setSelectedIndex(0);
            addressTextArea.setText("");
            resultLabel.setText("Form details will be displayed here.");
        });

        frame.setVisible(true);
    }
}
