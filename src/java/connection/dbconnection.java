package connection;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class dbconnection {
    private static dbconnection instance;
   public Connection con;
   public Connection getCon(){
       String dbname="letstalk?useSSL=false";
       String user="root";
       String password="";
       String url="jdbc:mysql://localhost:3306/"+dbname;
       try {
           Class.forName("com.mysql.cj.jdbc.Driver");
           con= DriverManager.getConnection(url,user,password);
           System.out.println("db succesfully");
       }catch (Exception e){
           e.printStackTrace();
           e.getCause();
       }
       return con;
   }
    public Connection getConnection() {
        return con;
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
