import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Crud_29 {
    public static void main(String[] args) {
        
        try {
            Class.forName("org.sqlite.JDBC");
            Connection connection = DriverManager.getConnection("jdbc:sqlite:database/student.db");

            String createTableSQL = "CREATE TABLE IF NOT EXISTS students (id INT PRIMARY KEY, name   VARCHAR(50))";
            Statement statement = connection.createStatement();
            statement.execute(createTableSQL);

            // Create 
            String insertSQL = "INSERT INTO students (id, name) VALUES (1, 'Sushank')";
            statement.executeUpdate(insertSQL);
            System.out.println("User inserted successfully");

            // Read 
            String selectSQL = "SELECT * FROM students";
            ResultSet resultSet = statement.executeQuery(selectSQL);
            while (resultSet.next()) {
                System.out.println("ID: " + resultSet.getInt("id") +
                        ", Name: " + resultSet.getString("name"));
            }

            // Update 
            String updateSQL = "UPDATE students SET name = 'Sushank' WHERE id = 1";
            statement.executeUpdate(updateSQL);
            System.out.println("User updated successfully");

            // Delete 
            String deleteSQL = "DELETE FROM students WHERE id = 1";
            statement.executeUpdate(deleteSQL);
            System.out.println("User deleted successfully");

            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
