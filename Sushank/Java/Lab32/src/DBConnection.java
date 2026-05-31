import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection {
    public static Connection getConnection() throws Exception {
        Class.forName("org.sqlite.JDBC");

        Connection connection = DriverManager.getConnection("jdbc:sqlite:student.db");
        createTable(connection);
        return connection;
    }

    static void createTable(Connection connection) throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS students ("
                + "id INTEGER PRIMARY KEY, "
                + "username TEXT NOT NULL, "
                + "password TEXT NOT NULL, "
                + "gender TEXT NOT NULL, "
                + "course TEXT NOT NULL, "
                + "country TEXT NOT NULL, "
                + "address TEXT NOT NULL"
                + ")";

        Statement statement = connection.createStatement();
        statement.execute(sql);
        statement.close();
    }
}
