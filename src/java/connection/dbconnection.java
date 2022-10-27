package connection;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class dbconnection {
     private static dbconnection instance;
    private Connection connection;
    private String url = "jdbc:mysql://localhost:3306/letstalk";
    private String username = "root";
    private String password = "";

    private dbconnection() throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            this.connection = (Connection) DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException ex) {
            System.out.println("Database Connection Creation Failed : " + ex.getMessage());
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public static dbconnection getInstance() throws SQLException {
        if (instance == null) {
            instance = new dbconnection();
        } else if (instance.getConnection().isClosed()) {
            instance = new dbconnection();
        }

        return instance;
    }
}
