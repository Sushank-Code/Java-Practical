import java.sql.*;
import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider;

public class rowset_31 {
    public static void main(String[] args) {
        try {
            Class.forName("org.sqlite.JDBC");
            Connection connection = DriverManager.getConnection("jdbc:sqlite:database/student.db");
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("SELECT id, name FROM students");

            CachedRowSet rowSet = RowSetProvider.newFactory().createCachedRowSet();
            rowSet.populate(resultSet);

            if (!rowSet.first()) {
                System.out.println("No records found in student.db");
                resultSet.close();
                statement.close();
                connection.close();
                return;
            }

            System.out.println("All records using RowSet:");
            rowSet.beforeFirst();
            while (rowSet.next()) {
                System.out.println(rowSet.getInt("id") + " "
                        + rowSet.getString("name"));
            }

            System.out.println("\nScrollable RowSet Example:");
            rowSet.first();
            System.out.println("First record: " + rowSet.getString("name"));

            rowSet.last();
            System.out.println("Last record: " + rowSet.getString("name"));

            rowSet.first();
            rowSet.updateString("name", "Sushank Lamsal");
            rowSet.updateRow();
            System.out.println("\nFirst row updated in RowSet.");

            PreparedStatement updateStatement = connection
                    .prepareStatement("UPDATE students SET name = ? WHERE id = ?");
            updateStatement.setString(1, rowSet.getString("name"));
            updateStatement.setInt(2, rowSet.getInt("id"));
            updateStatement.executeUpdate();

            System.out.println("\nRecords after update:");
            ResultSet updatedResultSet = statement.executeQuery("SELECT id, name FROM students");
            while (updatedResultSet.next()) {
                System.out.println(updatedResultSet.getInt("id") + " "
                        + updatedResultSet.getString("name"));
            }

            updatedResultSet.close();
            resultSet.close();
            updateStatement.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
