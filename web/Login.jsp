<%-- 
    Document   : Login
    Created on : 29 Sep, 2022, 10:12:54 AM
    Author     : baish
--%>

<%@ page import="java.sql.*" %> 
<%@ page import="java.io.*" %> 
<%@ page import="connection.dbconnection"%>
        <%   
        String user = request.getParameter("email");
        String pass = request.getParameter("pass");
        dbconnection connow=new dbconnection();
        Connection connectDB=connow.getCon();
        String Loginveryfy="Select count(1) from user where email='"+user+"' and password='"+pass+"'";
        if(user.isEmpty()){
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
                 response.sendRedirect("home.html");

                }else{
                    out.println("Incorrect login credentials");
                 //   alert.setHeaderText("Look, an Information Dialog");

                }
            }
        }catch (Exception e){
             //throw new ServletException("login faild",e);
            
        } 
         } 
            
            %>
