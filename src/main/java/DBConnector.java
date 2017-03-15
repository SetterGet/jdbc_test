import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Dell on 15.03.2017.
 */
public class DBConnector {

    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";
    private static final String URL = "jdbc:mysql://localhost:3307/mydatabase";

    private Connection connection;

    public DBConnector() {
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            System.err.println("Failed. Error to connect");
        }
    }

    public Connection getConnection() {
        return connection;
    }
}
