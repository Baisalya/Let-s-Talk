/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import connection.dbconnection;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
public class ShowUserDeatails extends HttpServlet {
PreparedStatement pst;
    //String email;
    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
                HttpSession session = request.getSession();
         String email= (String) session.getAttribute("email");
        //System.out.println(email+"hey");

        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
         HttpSession session = request.getSession(false);
          PrintWriter out = response.getWriter();
            String uemail = request.getParameter("useremail");
            String uname=request.getParameter("username");
            String fullname=request.getParameter("fullName");
            String UserEmail=request.getParameter("eMail");
             String email= (String) session.getAttribute("email");
            String name=(String) session.getAttribute("name");
        //response.sendRedirect("Profile.html");
           dbconnection connow=new dbconnection();
           Connection connectDB=connow.getCon();
         String userdetail="Select * from user where email='"+email+"' and name='"+name+"'";
         try {
             //Connection connectDB=connow.getCon();
             pst=connectDB.prepareStatement(userdetail);
            ResultSet rs=pst.executeQuery();
                         if (rs.next()== false){
                    //name= resultSet.getString("name");
                     // uemail=email;
                     // name=uname;
                     // out.print(email);
                    //out.println("Correct login credentials"+email);
                // session.setAttribute("email",email);
                 //session.setAttribute("name",name);
                 //System.out.print(name+"sucess");
                // out.println(session.getAttribute(email));
                }else{
                    // response.sendRedirect("Profile.jsp");
                     session.setAttribute("email","email");
                     session.setAttribute("name",name);
                     String username=rs.getString(2);
                     String useremail=rs.getString(3);
                         System.out.print("sucess");
                         out.println(username);
                     request.setAttribute("name",username);
                     request.setAttribute("email", useremail);
                    // fullname.equals("username");
                     request.getRequestDispatcher("Profile.jsp").forward(request, response);
                   
                   //  String u_email=rs.getString("email");
                   // String u_name=rs.getString("name");
                    //uname=rs.getString(name);
                    //uemail=rs.getString(email);
                  //  fullname=rs.getString("name");
                   // UserEmail=rs.getString(email);
                    //
                    
                     
                    
                

                         }       
            
        }catch (Exception e){
             throw new ServletException("login faild",e);
                    
        } 
         
        
        
        
        
        /**  try{
            
            response.setContentType("text/html");
            PrintWriter out =response.getWriter();
            processRequest(request, response);
            HttpSession session = request.getSession(false);
            String email= (String) session.getAttribute("email");
            String name=(String) session.getAttribute("name");
            System.out.println(email+"hey"+name);
        
            // String l="lala";
           //l=emai;
            email=uemail;
        }catch(Exception e){
         System.out.println(e);
        } **/
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
