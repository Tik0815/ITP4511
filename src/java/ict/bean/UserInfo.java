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
public class UserInfo implements Serializable {
    private String username;
    private String password;
    
    public UserInfo(){
        
    }
    public String getUsername(){
        return username;
    }
    public void setUsername(String name){
        this.username = name;
    }
    public String getPassword(){
        return password;
    }
    public void setPassword(String pw){
        this.password = pw;
    }
}
