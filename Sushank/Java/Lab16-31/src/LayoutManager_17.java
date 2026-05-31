import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class LayoutManager_17 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Layout Manager Demo");
        frame.setSize(600, 450);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTabbedPane tabs = new JTabbedPane();
        tabs.add("Null", createNullLayoutPanel());
        tabs.add("Flow", createFlowLayoutPanel());
        tabs.add("Card", createCardLayoutPanel());
        tabs.add("Border", createBorderLayoutPanel());
        tabs.add("Grid", createGridLayoutPanel());
        tabs.add("GridBag", createGridBagLayoutPanel());
        tabs.add("Group", createGroupLayoutPanel());

        frame.add(tabs);
        frame.setVisible(true);
    }

    static JPanel createNullLayoutPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(null);

        JLabel label = new JLabel("Null Layout");
        label.setBounds(40, 40, 120, 25);
        panel.add(label);

        JButton button = new JButton("Button");
        button.setBounds(40, 80, 100, 30);
        panel.add(button);

        JTextField textField = new JTextField("Fixed position");
        textField.setBounds(40, 130, 160, 30);
        panel.add(textField);

        return panel;
    }

    static JPanel createFlowLayoutPanel() {
        JPanel panel = new JPanel(new FlowLayout());

        panel.add(new JButton("One"));
        panel.add(new JButton("Two"));
        panel.add(new JButton("Three"));
        panel.add(new JButton("Four"));

        return panel;
    }

    static JPanel createCardLayoutPanel() {
        JPanel mainPanel = new JPanel(new BorderLayout());
        CardLayout cardLayout = new CardLayout();
        JPanel cardPanel = new JPanel(cardLayout);

        JPanel firstCard = new JPanel();
        firstCard.add(new JLabel("This is first card"));

        JPanel secondCard = new JPanel();
        secondCard.add(new JLabel("This is second card"));

        cardPanel.add(firstCard, "First");
        cardPanel.add(secondCard, "Second");

        JButton nextButton = new JButton("Next Card");
        nextButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.next(cardPanel);
            }
        });

        mainPanel.add(cardPanel, BorderLayout.CENTER);
        mainPanel.add(nextButton, BorderLayout.SOUTH);

        return mainPanel;
    }

    static JPanel createBorderLayoutPanel() {
        JPanel panel = new JPanel(new BorderLayout());

        panel.add(new JButton("North"), BorderLayout.NORTH);
        panel.add(new JButton("South"), BorderLayout.SOUTH);
        panel.add(new JButton("East"), BorderLayout.EAST);
        panel.add(new JButton("West"), BorderLayout.WEST);
        panel.add(new JButton("Center"), BorderLayout.CENTER);

        return panel;
    }

    static JPanel createGridLayoutPanel() {
        JPanel panel = new JPanel(new GridLayout(2, 3));

        panel.add(new JButton("1"));
        panel.add(new JButton("2"));
        panel.add(new JButton("3"));
        panel.add(new JButton("4"));
        panel.add(new JButton("5"));
        panel.add(new JButton("6"));

        return panel;
    }

    static JPanel createGridBagLayoutPanel() {
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(new JLabel("Name:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        panel.add(new JTextField(12), gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(new JLabel("Class:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        panel.add(new JTextField(12), gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        panel.add(new JButton("Submit"), gbc);

        return panel;
    }

    static JPanel createGroupLayoutPanel() {
        JPanel panel = new JPanel();

        JLabel nameLabel = new JLabel("Name:");
        JTextField nameTextField = new JTextField(12);
        JLabel addressLabel = new JLabel("Address:");
        JTextField addressTextField = new JTextField(12);
        JButton saveButton = new JButton("Save");

        GroupLayout layout = new GroupLayout(panel);
        panel.setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        layout.setHorizontalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup()
                        .addComponent(nameLabel)
                        .addComponent(addressLabel))
                .addGroup(layout.createParallelGroup()
                        .addComponent(nameTextField)
                        .addComponent(addressTextField)
                        .addComponent(saveButton)));

        layout.setVerticalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup()
                        .addComponent(nameLabel)
                        .addComponent(nameTextField))
                .addGroup(layout.createParallelGroup()
                        .addComponent(addressLabel)
                        .addComponent(addressTextField))
                .addComponent(saveButton));

        return panel;
    }
}
