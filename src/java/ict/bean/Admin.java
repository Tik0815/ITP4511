package ict.bean;

import java.io.Serializable;

public class Admin implements Serializable {
    
    private String id;
    private String ac;
    private String pw;
    private String firstName;
    private String lastName;
 
    
    public Admin(){
        
    }  
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
        return firstName;
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

}



