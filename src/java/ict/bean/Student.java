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
public class Student implements Serializable {
    //private String userId;
    private String firstName;
    private String lastName;
    private String studentClass;
    private UserInfo info;
    
    public Student(){
        
    }
    public UserInfo getInfo(){
        return info;
    }
    public void setInfo(UserInfo info){
        this.info = info;
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
