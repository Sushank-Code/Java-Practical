import javax.swing.*;

public class ListSelectionEvent_25 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("List Selection Event Example");
        frame.setSize(400, 300);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        String[] courses = {"BCA", "BBS", "BIM", "CSIT"};
        JList<String> courseList = new JList<>(courses);

        JScrollPane scrollPane = new JScrollPane(courseList);
        scrollPane.setBounds(80, 40, 120, 90);
        frame.add(scrollPane);

        JLabel resultLabel = new JLabel("Select a course.");
        resultLabel.setBounds(80, 150, 250, 30);
        frame.add(resultLabel);

        courseList.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                resultLabel.setText("Selected course: " + courseList.getSelectedValue());
            }
        });

        frame.setVisible(true);
    }
}
