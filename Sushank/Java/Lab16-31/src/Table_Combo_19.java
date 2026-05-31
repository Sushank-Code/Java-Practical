import javax.swing.*;
import java.awt.*;

public class Table_Combo_19 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("JTable and JComboBox Example");
        frame.setSize(500, 350);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        JLabel courseLabel = new JLabel("Select Course:");
        String[] courses = { "BCA", "BBS", "BIM", "CSIT" };
        JComboBox<String> courseComboBox = new JComboBox<>(courses);

        JPanel topPanel = new JPanel();
        topPanel.add(courseLabel);
        topPanel.add(courseComboBox);
        frame.add(topPanel, BorderLayout.NORTH);

        String[] columns = { "Roll No", "Name", "Address" };
        String[][] data = {
                { "1", "Sushank", "Kathmandu" },
                { "2", "Sita", "Pokhara" },
                { "3", "Hari", "Lalitpur" },
                { "4", "Gita", "Bhaktapur" }
        };

        JTable table = new JTable(data, columns);
        JScrollPane scrollPane = new JScrollPane(table);
        frame.add(scrollPane, BorderLayout.CENTER);

        JLabel selectedLabel = new JLabel("Selected Course: BCA");
        frame.add(selectedLabel, BorderLayout.SOUTH);

        courseComboBox.addActionListener(e -> {
            selectedLabel.setText("Selected Course: " + courseComboBox.getSelectedItem());
        });

        frame.setVisible(true);
    }
}
