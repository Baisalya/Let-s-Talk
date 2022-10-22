/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import connection.dbconnection;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author baish
 */
//@WebServlet("/NewServlet")
public class NewServlet extends HttpServlet {

 
    private static final long serialVersionUID = 1L;

    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        HttpSession session = request.getSession(true);
        PrintWriter out = response.getWriter();
        String email = request.getParameter("email");
        String pass = request.getParameter("pass");
        String name;
        
         dbconnection connow=new dbconnection();
        Connection connectDB=connow.getCon();
        String Loginveryfy="Select * from user where email='"+email+"' and password='"+pass+"'";
        if(email.isEmpty()){
        out.println("username cant be empty");
      
        }  else if(pass.isEmpty()){
        out.println("password cant be empty");
        }
        
        else{
   try {
            Statement statement=connectDB.createStatement();
            ResultSet resultSet=statement.executeQuery(Loginveryfy);
         
            while (resultSet.next()){
                if (resultSet.getInt(1)==1){
                    name= resultSet.getString("name");
                      response.sendRedirect("home.html");
                    //out.println("Correct login credentials"+email);
                 session.setAttribute("email",email);
                 session.setAttribute("name",name);
                // out.println(session.getAttribute(email));
                }else{
                    out.println("Incorrect login credentials");
                 //   alert.setHeaderText("Look, an Information Dialog");

                }
            }
        }catch (Exception e){

             throw new ServletException("login faild",e);

          
            
        } 
         } 
     /**   if(user.isEmpty() || pass.isEmpty()){
        out.println("username and password cant be empty");
        }else{
         try {
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/letstalk?useSSL=false","root","");
        
        Statement stm=conn.createStatement();
         
        ResultSet rs=stm.executeQuery("Select * from user where name='"+user+"' and password='"+pass+"'");
          out.println("Correct login credentials");
     //  PreparedStatement pst = conn.prepareStatement("Select from 'user' where email= and password=?");
       // pst.setString(1, user);
       //  pst.setString(2, pass);
       // ResultSet rs = pst.executeQuery();
        if (rs.next()) {
        //out.println("Correct login credentials");
        response.sendRedirect("Signup.html");
        } 
        else {
        out.println("Incorrect login credentials");
        }
        } 
        catch (Exception e ) {
           throw new ServletException("login faild",e);
        } 
    } **/
    }
}

 
