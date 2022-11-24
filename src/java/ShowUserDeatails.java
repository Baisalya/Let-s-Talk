/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Dao.UserDAO;
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
import model.User;

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
         if (session == null || session.getAttribute("user_id") == null) {
			response.sendRedirect("login");
			return;
		}
          PrintWriter out = response.getWriter();
           // String uemail = request.getParameter("useremail");
           // String uname=request.getParameter("username");
           // String fullname=request.getParameter("fullName");
            String UserEmail=request.getParameter("eMail");
             String email= (String) session.getAttribute("email");
            String name=(String) session.getAttribute("name");
        //response.sendRedirect("Profile.html");      
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
        doGet(request, response);
         response.setContentType("text/html");
            PrintWriter out = response.getWriter();
             HttpSession session = request.getSession(false);
            //String fullname=request.getParameter("fullName").trim();
           // String UserEmail=request.getParameter("eMail").trim();
            	if (session == null || session.getAttribute("user_id") == null) {
			response.sendRedirect("login");
			return;
		}		
		String type = request.getParameter("type");
		if(type.equals("change_profile")) {
			String fullname=request.getParameter("fullName").trim();
                        String UserEmail=request.getParameter("eMail").trim();
			
			if(fullname.equals("") || UserEmail.equals("")) {
                                out.println("Type all required fields.");
//				request.setAttribute("pmsg", "Type all required fields.");
				doGet(request, response);
			} else {
				UserDAO userDAO = new UserDAO();
				User user = new User();
				user.setUser_id((int) session.getAttribute("user_id"));
				user.setName(fullname);
				user.setEmail(UserEmail);
				String result = userDAO.updateProfile(user);
				//request.setAttribute("pmsg", result);
                                response.sendRedirect("Profile.jsp");
				doGet(request, response);
			}
            
    }

    }/**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }
    // </editor-fold>

}
