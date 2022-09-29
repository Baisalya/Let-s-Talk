<%-- 
    Document   : Signup
    Created on : 29 Sep, 2022, 10:21:45 AM
    Author     : baish
--%>
<%@page import="java.util.regex.Matcher"%>
<%@page import="java.util.regex.Pattern"%>
<%@ page import="java.sql.*" %> 
<%@ page import="java.io.*" %> 
<%@ page import="connection.dbconnection"%>
<% 

        String name = request.getParameter("name");
        String email=request.getParameter("email");
        String pass = request.getParameter("pass");
        
       // String regex="^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()?[{}]:;',?/*~$^+=<>]).{6}$";
         dbconnection connow=new dbconnection();
        Connection connectDB=connow.getCon();
        String Signupquerry="insert into user(name,email,password)values('";
        String insertfield=name+"','"+email +"','"+ pass +"')";
        String veryfysignup=Signupquerry+insertfield;
      
          if(name.isEmpty()|| email.isEmpty()){
             out.println("name and email can't be empty");
            
        }else if (email.isEmpty() || pass.isEmpty()){
             out.println("username and password can't be empty");
           
        }
        else{
          try {
            Statement statement=connectDB.createStatement();
            statement.executeUpdate(veryfysignup);
            response.sendRedirect("index.html");
            System.out.println("sucessfull");
        }catch (Exception e){
           throw new ServletException("Signup faild",e);
        }
%>
