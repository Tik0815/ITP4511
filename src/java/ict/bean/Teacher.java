package ict.bean;

import java.io.Serializable;

public class Teacher implements Serializable {
    
    private String id;
    private String ac;
    private String pw;
    private String firstName;
    private String lastName;
    private String phone;
    private String email;
 
    
    public Teacher(){}  
    public String getId(){
        return id;
    }
    public void setID(String id){
        this.id = id;
    }   
    public String getAc(){
        return ac;
    }
    public void setAc(String ac){
        this.ac = ac;
    }   
    public String getPw(){
        return pw;
    }
    public void setPw(String pw){
        this.pw = pw;
    }    
    public String getFirstName(){
        return firstName;
    }
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }
    public String getLastName(){
        return lastName;
    }
    public void setLastName(String lastName){
        this.lastName = lastName;
    }
    public String getPhone(){
        return phone;
    }
    public void setPhone(String phone){
        this.phone = phone;
    }
    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email = email;
    }  
}
