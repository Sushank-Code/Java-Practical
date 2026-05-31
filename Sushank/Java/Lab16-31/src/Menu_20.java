import javax.swing.*;
import java.awt.*;
import javax.swing.tree.DefaultMutableTreeNode;

public class Menu_20 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Menu Example");
        frame.setSize(550, 450);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        JLabel messageLabel = new JLabel("Use menu options to see the result.");
        frame.add(messageLabel, BorderLayout.SOUTH);

        JMenuBar menuBar = new JMenuBar();

        JMenu fileMenu = new JMenu("File");
        fileMenu.setMnemonic('F');

        JMenuItem openItem = new JMenuItem("Open File");
        openItem.setMnemonic('O');
        openItem.setAccelerator(KeyStroke.getKeyStroke("ctrl O"));

        JMenuItem exitItem = new JMenuItem("Exit");
        exitItem.setMnemonic('X');

        fileMenu.add(openItem);
        fileMenu.add(exitItem);

        JMenu optionMenu = new JMenu("Options");
        optionMenu.setMnemonic('O');

        JRadioButtonMenuItem smallItem = new JRadioButtonMenuItem("Small Text");
        JRadioButtonMenuItem largeItem = new JRadioButtonMenuItem("Large Text");
        smallItem.setMnemonic('S');
        largeItem.setMnemonic('L');

        ButtonGroup sizeGroup = new ButtonGroup();
        sizeGroup.add(smallItem);
        sizeGroup.add(largeItem);

        JCheckBoxMenuItem boldItem = new JCheckBoxMenuItem("Bold");
        boldItem.setMnemonic('B');

        optionMenu.add(smallItem);
        optionMenu.add(largeItem);
        optionMenu.add(boldItem);

        JMenu toolsMenu = new JMenu("Tools");
        toolsMenu.setMnemonic('T');

        JMenuItem dialogItem = new JMenuItem("Dialog Box");
        dialogItem.setMnemonic('D');

        JMenuItem colorItem = new JMenuItem("Color Chooser");
        colorItem.setMnemonic('C');

        toolsMenu.add(dialogItem);
        toolsMenu.add(colorItem);

        menuBar.add(fileMenu);
        menuBar.add(optionMenu);
        menuBar.add(toolsMenu);

        frame.setJMenuBar(menuBar);

        DefaultMutableTreeNode root = new DefaultMutableTreeNode("Computer");
        DefaultMutableTreeNode documents = new DefaultMutableTreeNode("Documents");
        DefaultMutableTreeNode pictures = new DefaultMutableTreeNode("Pictures");
        DefaultMutableTreeNode music = new DefaultMutableTreeNode("Music");

        documents.add(new DefaultMutableTreeNode("Java Notes"));
        documents.add(new DefaultMutableTreeNode("Lab Report"));
        pictures.add(new DefaultMutableTreeNode("Photo"));
        music.add(new DefaultMutableTreeNode("Song"));

        root.add(documents);
        root.add(pictures);
        root.add(music);

        JTree tree = new JTree(root);
        JScrollPane treeScrollPane = new JScrollPane(tree);

        JPanel centerPanel = new JPanel(new BorderLayout());
        centerPanel.add(new JLabel("JTree Example:"), BorderLayout.NORTH);
        centerPanel.add(treeScrollPane, BorderLayout.CENTER);
        frame.add(centerPanel, BorderLayout.CENTER);

        openItem.addActionListener(e -> {
            JFileChooser fileChooser = new JFileChooser();
            int result = fileChooser.showOpenDialog(frame);

            if (result == JFileChooser.APPROVE_OPTION) {
                messageLabel.setText("Selected file: " + fileChooser.getSelectedFile().getName());
            } else {
                messageLabel.setText("No file selected.");
            }
        });

        exitItem.addActionListener(e -> {
            System.exit(0);
        });

        smallItem.addActionListener(e -> {
            messageLabel.setText("Small text menu item selected.");
        });

        largeItem.addActionListener(e -> {
            messageLabel.setText("Large text menu item selected.");
        });

        boldItem.addActionListener(e -> {
            if (boldItem.isSelected()) {
                messageLabel.setText("Checkbox menu item selected.");
            } else {
                messageLabel.setText("Checkbox menu item unselected.");
            }
        });

        dialogItem.addActionListener(e -> {
            JOptionPane.showMessageDialog(frame, "This is a dialog box.");
            messageLabel.setText("Dialog box displayed.");
        });

        colorItem.addActionListener(e -> {
            Color color = JColorChooser.showDialog(frame, "Choose Color", Color.WHITE);

            if (color != null) {
                centerPanel.setBackground(color);
                messageLabel.setText("Color selected.");
            } else {
                messageLabel.setText("No color selected.");
            }
        });

        frame.setVisible(true);
    }
}
