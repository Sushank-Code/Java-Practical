import javax.swing.*;

public class ButtonEvent_21 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Button Event Example");
        frame.setSize(400, 250);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JRadioButton maleRadioButton = new JRadioButton("Male");
        maleRadioButton.setBounds(80, 40, 80, 30);
        frame.add(maleRadioButton);

        JRadioButton femaleRadioButton = new JRadioButton("Female");
        femaleRadioButton.setBounds(180, 40, 100, 30);
        frame.add(femaleRadioButton);

        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(maleRadioButton);
        genderGroup.add(femaleRadioButton);

        JButton button = new JButton("Submit");
        button.setBounds(130, 90, 100, 30);
        frame.add(button);

        JLabel resultLabel = new JLabel("Select radio button and click submit.");
        resultLabel.setBounds(70, 140, 280, 30);
        frame.add(resultLabel);

        button.addActionListener(e -> {
            if (maleRadioButton.isSelected()) {
                resultLabel.setText("Male selected.");
            } else if (femaleRadioButton.isSelected()) {
                resultLabel.setText("Female selected.");
            } else {
                resultLabel.setText("No radio button selected.");
            }
        });

        frame.setVisible(true);
    }
}
