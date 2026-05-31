import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Add_Sub_28 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Add and Subtract");
        frame.setSize(400, 300);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel firstLabel = new JLabel("First Number:");
        firstLabel.setBounds(50, 40, 100, 25);
        frame.add(firstLabel);

        JTextField firstTextField = new JTextField();
        firstTextField.setBounds(170, 40, 150, 25);
        frame.add(firstTextField);

        JLabel secondLabel = new JLabel("Second Number:");
        secondLabel.setBounds(50, 80, 120, 25);
        frame.add(secondLabel);

        JTextField secondTextField = new JTextField();
        secondTextField.setBounds(170, 80, 150, 25);
        frame.add(secondTextField);

        JButton addButton = new JButton("Add");
        addButton.setBounds(80, 130, 100, 30);
        frame.add(addButton);

        JButton subtractButton = new JButton("Subtract");
        subtractButton.setBounds(200, 130, 100, 30);
        frame.add(subtractButton);

        JLabel resultLabel = new JLabel("Result will be displayed here.");
        resultLabel.setBounds(80, 185, 250, 30);
        frame.add(resultLabel);

        addButton.addActionListener(e -> {
            int firstNumber = Integer.parseInt(firstTextField.getText());
            int secondNumber = Integer.parseInt(secondTextField.getText());
            int sum = firstNumber + secondNumber;

            resultLabel.setText("Sum: " + sum);
        });

        subtractButton.addActionListener(e -> {
            int firstNumber = Integer.parseInt(firstTextField.getText());
            int secondNumber = Integer.parseInt(secondTextField.getText());
            int difference = firstNumber - secondNumber;

            resultLabel.setText("Difference: " + difference);
        });

        frame.setVisible(true);
    }
}
