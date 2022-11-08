/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author baishalya
 */
public class Feedback {
   
    	private int id;
	private String name;
	private String email;
	private String phone;
	private String feedback;
        
        public Feedback(){}
        
        public Feedback(int id,String name, String email,String phone,String feedback){
        super();
        this.id=id;
        this.name=name;
        this.email=email;
        this.phone=phone;
        this.feedback=feedback;
        
        }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFeedback() {
        return feedback;
    }
 public void setFeedback(String feedback) {
        this.feedback = feedback;
    }



    
}
