/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ict.bean;

import java.beans.*;
import java.io.Serializable;

/**
 *
 * @author Tik0815
 */
public class StudentBean implements Serializable {
    private String id;
    private String pw;
    private String firstName;
    private String lastName;
    private String studentClass;
    private UserInfo info;
    
    public StudentBean(){
        
    }
    public UserInfo getInfo(){
        return info;
    }
    public void setInfo(UserInfo info){
        this.info = info;
    }
    
    public String getId(){
        return id;
    }
    public void setId(String id){
        this.id = id;
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
    public String getStudentClass(){
        return studentClass;
    }
    public void setStudentClass(String studentClass){
        this.studentClass = studentClass;
    }
}
