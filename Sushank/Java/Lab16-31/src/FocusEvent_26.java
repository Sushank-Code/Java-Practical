import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.*;

public class FocusEvent_26 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Focus Event Example");
        frame.setSize(400, 250);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTextField nameTextField = new JTextField();
        nameTextField.setBounds(80, 50, 220, 30);
        frame.add(nameTextField);

        JTextField addressTextField = new JTextField();
        addressTextField.setBounds(80, 90, 220, 30);
        frame.add(addressTextField);

        JLabel resultLabel = new JLabel("Click inside a text field.");
        resultLabel.setBounds(80, 140, 250, 30);
        frame.add(resultLabel);

        nameTextField.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent e) {
                resultLabel.setText("Name field got focus.");
            }

            public void focusLost(FocusEvent e) {
                resultLabel.setText("Name field lost focus.");
            }
        });

        addressTextField.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent e) {
                resultLabel.setText("Address field got focus.");
            }

            public void focusLost(FocusEvent e) {
                resultLabel.setText("Address field lost focus.");
            }
        });

        frame.setVisible(true);
    }
}
