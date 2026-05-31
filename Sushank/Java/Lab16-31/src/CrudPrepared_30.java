import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CrudPrepared_30 {
    public static void main(String[] args) {
        try {
            Class.forName("org.sqlite.JDBC");
            Connection connection = DriverManager.getConnection("jdbc:sqlite:database/employee.db");

            String createTableSQL = "CREATE TABLE IF NOT EXISTS employees (id INT PRIMARY KEY, name VARCHAR(50), salary INT)";
            Statement statement = connection.createStatement();
            statement.execute(createTableSQL);

            // Create operation
            String insertSQL = "INSERT INTO employees (id, name, salary) VALUES (?, ?, ?)";
            PreparedStatement insertStatement = connection.prepareStatement(insertSQL);
            insertStatement.setInt(1, 1);
            insertStatement.setString(2, "Sushank Lamsal");
            insertStatement.setInt(3, 25000);
            insertStatement.executeUpdate();
            System.out.println("Employee inserted successfully");

            // Read operation
            String selectSQL = "SELECT * FROM employees";
            PreparedStatement selectStatement = connection.prepareStatement(selectSQL);
            ResultSet resultSet = selectStatement.executeQuery();

            System.out.println("Employee Records:");
            while (resultSet.next()) {
                System.out.println("ID: " + resultSet.getInt("id")
                        + ", Name: " + resultSet.getString("name")
                        + ", Salary: " + resultSet.getInt("salary"));
            }

            // Update operation
            String updateSQL = "UPDATE employees SET name = ?, salary = ? WHERE id = ?";
            PreparedStatement updateStatement = connection.prepareStatement(updateSQL);
            updateStatement.setString(1, "Hari");
            updateStatement.setInt(2, 30000);
            updateStatement.setInt(3, 1);
            updateStatement.executeUpdate();
            System.out.println("Employee updated successfully");

            // Delete operation
            String deleteSQL = "DELETE FROM employees WHERE id = ?";
            PreparedStatement deleteStatement = connection.prepareStatement(deleteSQL);
            deleteStatement.setInt(1, 1);
            deleteStatement.executeUpdate();
            System.out.println("Employee deleted successfully");

            resultSet.close();
            statement.close();
            insertStatement.close();
            selectStatement.close();
            updateStatement.close();
            deleteStatement.close();
            connection.close();
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
