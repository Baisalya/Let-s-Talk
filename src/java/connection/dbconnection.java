package connection;


import java.sql.Connection;
import java.sql.DriverManager;

public class dbconnection {

   public Connection con;
   public Connection getCon(){
       String dbname="letstalk?useSSL=false";
       String user="root";
       String password="Kunmun@2001";
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
}
