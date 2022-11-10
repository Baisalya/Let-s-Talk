/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import connection.dbconnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.Feedback;

/**
 *
 * @author baish
 */
public class FeedbackDAO {
    
    public String SentFeedback(Feedback feedback) {
        try{
            Connection conn=dbconnection.getInstance().getConnection();
            PreparedStatement st = conn.prepareStatement("INSERT INTO feedback(name,email,phone,feedback) VALUES (?,?,?,?);");
            st.setString(1, feedback.getName());
            st.setString(2, feedback.getEmail());
            st.setString(3, feedback.getPhone());
            st.setString(4, feedback.getFeedback());
            st.execute();
            return "Successfully Sent";
            
          }catch(Exception e){
              e.printStackTrace();
        return "unsucessfull";
    }
    } 
}
