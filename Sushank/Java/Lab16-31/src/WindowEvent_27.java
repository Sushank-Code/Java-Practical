import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.*;

public class WindowEvent_27 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Window Event Example");
        frame.setSize(400, 250);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel resultLabel = new JLabel("Open, minimize, restore, or close the window.");
        resultLabel.setBounds(50, 80, 320, 30);
        frame.add(resultLabel);

        frame.addWindowListener(new WindowAdapter() {
            public void windowOpened(WindowEvent e) {
                resultLabel.setText("Window opened.");
            }

            public void windowIconified(WindowEvent e) {
                System.out.println("Window minimized.");
            }

            public void windowDeiconified(WindowEvent e) {
                resultLabel.setText("Window restored.");
            }

            public void windowClosing(WindowEvent e) {
                System.out.println("Window closing.");
            }
        });

        frame.setVisible(true);
    }
}
