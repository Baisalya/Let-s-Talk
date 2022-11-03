/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import connection.dbconnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.User;
/**
 *
 * @author baish
 */
public class UserDAO {
    	public boolean login(String email, String password) {
		boolean result = false;
		try {
			Connection conn = dbconnection.getInstance().getConnection();
			PreparedStatement st = conn.prepareStatement("SELECT * FROM user WHERE email = ? AND password = ?");
			st.setString(1, email);
			st.setString(2, password);
			ResultSet rs = st.executeQuery();
			
			if(rs.next()) {
	            if(rs.getString("email").equals(email) && rs.getString("password").equals(password)) {
	            	result = true;
	            }
	        }
		} catch (SQLException e) {
			result = false;
		}
		return result;
		
	}
        	public String register(User user) {
		try {
			Connection conn = dbconnection.getInstance().getConnection();
			PreparedStatement st = conn.prepareStatement("INSERT INTO user(name, email, password) VALUES (?, ?, ?, ?);");
			st.setString(1, user.getName());
			st.setString(3, user.getEmail());
			st.setString(4, user.getPassword());
			st.execute();
			return "Registration Successful.";
		} catch (Exception e) {
			e.printStackTrace();
			return "Email alreay used.";
		}
	}
        public User getUserByEmail(String email) throws SQLException {
		Connection conn = dbconnection.getInstance().getConnection();
		PreparedStatement st = conn.prepareStatement("SELECT * FROM user WHERE email = ?");
		st.setString(1, email);
		ResultSet rs = st.executeQuery();
		User u = new User();
		if(rs.next()) {
			u.setUser_id(rs.getInt("user_id"));
			u.setName(rs.getString("name"));
			u.setEmail(rs.getString("email"));
			u.setPassword(rs.getString("password"));
			u.setQuestion(rs.getString("question"));
		}
		return u;
	}
    	public User getUserById(int id) throws SQLException {
		Connection conn = dbconnection.getInstance().getConnection();
		PreparedStatement st = conn.prepareStatement("SELECT * FROM user WHERE user_id = ?");
		st.setInt(1, id);
		ResultSet rs = st.executeQuery();
		User u = new User();
		if(rs.next()) {
			u.setUser_id(rs.getInt("user_id"));
			u.setName(rs.getString("name"));
			u.setEmail(rs.getString("email"));
			u.setPassword(rs.getString("password"));
			u.setQuestion(rs.getString("question"));
			
		}
		return u;
	}
   public  ArrayList<User> getAllUsers(int id)throws SQLException {  
          
       Connection conn = dbconnection.getInstance().getConnection();  
        PreparedStatement st = conn.prepareStatement("select * from user");  
        st.setInt(1, id);
        ResultSet rs=st.executeQuery(); 
         ArrayList<User> array=new ArrayList<User>(); 
        while(rs.next()){  
            User u=new User();  
            u.setUser_id(rs.getInt("id"));  
            u.setName(rs.getString("name"));  
            u.setEmail(rs.getString("email"));  
            array.add(u);  
        }  
      
    return array;  
} 
    	public ArrayList<User> getUsersForChat(int id) throws SQLException {
		Connection conn = dbconnection.getInstance().getConnection();
		PreparedStatement st = conn.prepareStatement("SELECT * FROM user WHERE user_id <> ?");
		st.setInt(1, id);
		ResultSet rs = st.executeQuery();
		ArrayList<User> array = new ArrayList<>();
		while(rs.next()) {
			User u = new User();
			u.setUser_id(rs.getInt("user_id"));
			u.setName(rs.getString("name"));
			u.setEmail(rs.getString("email"));
			u.setPassword(rs.getString("password"));
			u.setQuestion(rs.getString("question"));
			array.add(u);
		}
		return array; 
	}
    	public String updateProfile(User user) {
		try {
			Connection conn = dbconnection.getInstance().getConnection();
			PreparedStatement st = conn.prepareStatement("UPDATE user SET name = ?,email = ? WHERE user_id = ?;");
			st.setString(1, user.getName());
			st.setString(2, user.getEmail());
			st.setInt(3, user.getUser_id());
			st.execute();
			return "Profile Update Successful.";
		} catch (Exception e) {
			e.printStackTrace();
			return "Email alreay used.";
		} 
	}

 
}
