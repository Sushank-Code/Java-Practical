import java.awt.BorderLayout;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class DisplayData extends JFrame {
    JTable table;
    DefaultTableModel model;

    public DisplayData() {
        setTitle("Student Records");
        setSize(800, 400);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        String[] columns = {"ID", "Username", "Password", "Gender", "Course", "Country", "Address"};
        model = new DefaultTableModel(columns, 0) {
            public boolean isCellEditable(int row, int column) {
                return column != 0;
            }
        };
        table = new JTable(model);

        JLabel infoLabel = new JLabel("Edit table data, select row, then click Update Selected or Delete Selected.");
        add(infoLabel, BorderLayout.NORTH);

        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);

        JButton refreshButton = new JButton("Refresh");
        JButton updateButton = new JButton("Update Selected");
        JButton deleteButton = new JButton("Delete Selected");

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(refreshButton);
        buttonPanel.add(updateButton);
        buttonPanel.add(deleteButton);
        add(buttonPanel, BorderLayout.SOUTH);

        refreshButton.addActionListener(e -> loadData());
        updateButton.addActionListener(e -> updateStudent());
        deleteButton.addActionListener(e -> deleteStudent());

        loadData();
    }

    void loadData() {
        model.setRowCount(0);

        try {
            Connection connection = DBConnection.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM students");

            while (resultSet.next()) {
                Object[] row = {
                        resultSet.getInt("id"),
                        resultSet.getString("username"),
                        resultSet.getString("password"),
                        resultSet.getString("gender"),
                        resultSet.getString("course"),
                        resultSet.getString("country"),
                        resultSet.getString("address")
                };
                model.addRow(row);
            }

            resultSet.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }
    }

    void updateStudent() {
        int selectedRow = table.getSelectedRow();

        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Please select a row to update.");
            return;
        }

        if (table.isEditing()) {
            table.getCellEditor().stopCellEditing();
        }

        int id = Integer.parseInt(model.getValueAt(selectedRow, 0).toString());
        String username = model.getValueAt(selectedRow, 1).toString();
        String password = model.getValueAt(selectedRow, 2).toString();
        String gender = model.getValueAt(selectedRow, 3).toString();
        String course = model.getValueAt(selectedRow, 4).toString();
        String country = model.getValueAt(selectedRow, 5).toString();
        String address = model.getValueAt(selectedRow, 6).toString();

        try {
            Connection connection = DBConnection.getConnection();
            String sql = "UPDATE students SET username = ?, password = ?, gender = ?, course = ?, country = ?, address = ? WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, username);
            statement.setString(2, password);
            statement.setString(3, gender);
            statement.setString(4, course);
            statement.setString(5, country);
            statement.setString(6, address);
            statement.setInt(7, id);

            int rows = statement.executeUpdate();
            statement.close();
            connection.close();

            if (rows > 0) {
                JOptionPane.showMessageDialog(this, "Record updated successfully.");
            } else {
                JOptionPane.showMessageDialog(this, "Record not found.");
            }

            loadData();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }
    }

    void deleteStudent() {
        int selectedRow = table.getSelectedRow();

        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Please select a row to delete.");
            return;
        }

        int id = Integer.parseInt(model.getValueAt(selectedRow, 0).toString());

        try {
            Connection connection = DBConnection.getConnection();
            String sql = "DELETE FROM students WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setInt(1, id);

            int rows = statement.executeUpdate();
            statement.close();
            connection.close();

            if (rows > 0) {
                JOptionPane.showMessageDialog(this, "Record deleted successfully.");
            } else {
                JOptionPane.showMessageDialog(this, "Record not found.");
            }

            loadData();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }
    }
}
