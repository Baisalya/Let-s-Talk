/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author baish
 */
public class Updateuser extends HttpServlet {
String user;

    protected void doPost(HttpServletRequest request, HttpServletResponse response,String user)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        this.user=user;
        String u=request.getParameter("username");
        user=u;
        
        
    }

  

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
