import javax.swing.*;

public class CheckBoxEvent_22 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("CheckBox Event Example");
        frame.setSize(400, 250);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JCheckBox teaCheckBox = new JCheckBox("Tea");
        teaCheckBox.setBounds(80, 40, 80, 30);
        frame.add(teaCheckBox);

        JCheckBox coffeeCheckBox = new JCheckBox("Coffee");
        coffeeCheckBox.setBounds(180, 40, 100, 30);
        frame.add(coffeeCheckBox);

        JLabel resultLabel = new JLabel("Selected: None");
        resultLabel.setBounds(80, 100, 250, 30);
        frame.add(resultLabel);

        teaCheckBox.addItemListener(e -> {
            String selected = "";

            if (teaCheckBox.isSelected()) {
                selected = selected + "Tea ";
            }
            if (coffeeCheckBox.isSelected()) {
                selected = selected + "Coffee ";
            }
            if (selected.equals("")) {
                selected = "None";
            }

            resultLabel.setText("Selected: " + selected);
        });

        coffeeCheckBox.addItemListener(e -> {
            String selected = "";

            if (teaCheckBox.isSelected()) {
                selected = selected + "Tea ";
            }
            if (coffeeCheckBox.isSelected()) {
                selected = selected + "Coffee ";
            }
            if (selected.equals("")) {
                selected = "None";
            }

            resultLabel.setText("Selected: " + selected);
        });

        frame.setVisible(true);
    }
}
