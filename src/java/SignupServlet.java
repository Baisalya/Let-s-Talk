/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author baish
 */
public class SignupServlet extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
               response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String name = request.getParameter("name");
        String email=request.getParameter("email");
        String pass = request.getParameter("pass");
         dbconnection connow=new dbconnection();
        Connection connectDB=connow.getCon();
        String Signupquerry="insert into user(name,email,password)values('";
        String insertfield=name+"','"+email +"','"+ pass +"')";
        String veryfysignup=Signupquerry+insertfield;
          if(name.isEmpty()){
             out.println("name cant be empty");
            return;
        }if (email.isEmpty()){
             out.println("email cant be empty");
            return;

        }if (name.isEmpty() && email.isEmpty() && pass.isEmpty()){
             out.println("username and password cant be empty");
            return;
        }else{
          try {
            Statement statement=connectDB.createStatement();
            statement.executeUpdate(veryfysignup);
            response.sendRedirect("index.html");
            System.out.println("sucessfull");
        }catch (Exception e){
           throw new ServletException("Signup faild",e);
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
