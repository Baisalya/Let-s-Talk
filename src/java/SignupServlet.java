/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import static com.sun.corba.se.spi.presentation.rmi.StubAdapter.request;
import connection.dbconnection;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Statement;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author baish
 */
public class SignupServlet extends HttpServlet {
     String regex="^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{6}$";
private static final Pattern password_pattern=
        Pattern.compile("^"+                                  
             "(?=.*[0-9]) "+                     
             "(?=.*[a-z])"+                       
             "(?=.*[A-Z])"+                      
             "(?=.*[!@#&()–[{}]:;',?/*~$^+=<>])"+ 
             "{6}"+                           
             "$");
      //Matcher match=password_pattern.matcher(request.getParameter("pass"));

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
               response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String name = request.getParameter("name");
        String email=request.getParameter("email");
        String pass = request.getParameter("pass");
        Matcher match=password_pattern.matcher(pass);
        String regex="^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{6}$";
         dbconnection connow=new dbconnection();
        Connection connectDB=connow.getCon();
        String Signupquerry="insert into user(name,email,password)values('";
        String insertfield=name+"','"+email +"','"+ pass +"')";
        String veryfysignup=Signupquerry+insertfield;
        if(match.matches()){
         out.print("password lenght must be 6 with a number,uppercase,lowercase and with a special character");
         return ;
        }
          if(name.isEmpty()|| email.isEmpty()){
             out.println("name and email can't be empty");
            
        }else if (match.matches() || pass.matches(regex)){
             out.println("username and password can't be empty");
           
        }
        else{
          try {
            Statement statement=connectDB.createStatement();
            statement.executeUpdate(veryfysignup);
            response.sendRedirect("index.html");
            System.out.println("sucessfull");
        }catch (Exception e){
          // throw new ServletException("Signup faild",e);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
  // </editor-fold>
    }
}
