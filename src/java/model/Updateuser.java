/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author baish
 */
public class Updateuser {
      private int user_id;
    private String phone_no;
    private String websiteurl;
    private String location;
    private String dob;
    private String gender;    
    private String relationship;
    private String photo;
    private String text ;
    
    public Updateuser(){
    super();
    }
     public Updateuser(int user_id,String phone_no,String websiteurl,String location,String dob,String gender,String relationship,String photo,String text){
    super();
    this.user_id=user_id;
    this.phone_no=phone_no;
    this.location=location;
    this.dob=dob;
    this.gender=gender;
    this.relationship=relationship;
    this.photo=photo;
    this.text=text;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getPhone_no() {
        return phone_no;
    }

    public void setPhone_no(String phone_no) {
        this.phone_no = phone_no;
    }

    public String getWebsiteurl() {
        return websiteurl;
    }

    public void setWebsiteurl(String websiteurl) {
        this.websiteurl = websiteurl;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getRelationship() {
        return relationship;
    }

    public void setRelationship(String relationship) {
        this.relationship = relationship;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
  
}
