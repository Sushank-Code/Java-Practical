import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;

public class MouseEvent_23 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Mouse Event Example");
        frame.setSize(400, 250);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel resultLabel = new JLabel("Click anywhere inside the window.");
        resultLabel.setBounds(70, 80, 280, 30);
        frame.add(resultLabel);

        frame.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                resultLabel.setText("Mouse clicked at X: " + e.getX() + ", Y: " + e.getY());
            }
        });

        frame.setVisible(true);
    }
}
