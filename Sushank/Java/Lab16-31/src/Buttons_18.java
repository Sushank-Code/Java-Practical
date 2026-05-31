import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Buttons_18 extends JFrame implements ActionListener {
    JTextField textField;
    JButton b1, b2, b3, b4;

    public Buttons_18() {
        setTitle("Button Click Demo");
        setSize(400, 200);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Text Field
        textField = new JTextField(25);
        add(textField);

        // Buttons
        b1 = new JButton("Button 1");
        b2 = new JButton("Button 2");
        b3 = new JButton("Button 3");
        b4 = new JButton("Button 4");
        add(b1);
        add(b2);
        add(b3);
        add(b4);

        // Add Action Listener 
        b1.addActionListener(this); 
        b2.addActionListener(this);
        b3.addActionListener(this); 
        b4.addActionListener(this);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {
            textField.setText("First button is clicked");
        } else if (e.getSource() == b2) {
            textField.setText("Second button is clicked");
        } else if (e.getSource() == b3) {
            textField.setText("Third button is clicked");
        } else if (e.getSource() == b4) {
            textField.setText("Fourth button is clicked");
        }
    }

    public static void main(String[] args) {
        new Buttons_18();
    }
}
