import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.*;

public class KeyEvent_24 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Key Event Example");
        frame.setSize(400, 250);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTextField textField = new JTextField();
        textField.setBounds(80, 50, 220, 30);
        frame.add(textField);

        JLabel resultLabel = new JLabel("Type something in the text field.");
        resultLabel.setBounds(80, 100, 250, 30);
        frame.add(resultLabel);

        textField.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                resultLabel.setText("Key released: " + e.getKeyChar());
            }
        });

        frame.setVisible(true);
    }
}
