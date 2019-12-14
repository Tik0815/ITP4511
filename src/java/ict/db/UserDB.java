/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ict.db;

import ict.bean.Student;
import ict.bean.Teacher;
import java.io.IOException;
import java.sql.*;
/**
 *
 * @author Tik0815
 */

public class UserDB {
    
    private String url = "";
    private String username = "";
    private String password = "";
    
    public UserDB(String dburl, String dbUser, String dbPassword){
        this.url = url;
        this.username = username;
        this.password = password;
    }
    public Connection getConnection() throws SQLException, IOException {
        try{
            Class.forName("com.mysql.jdbc.Driver");
        }catch(ClassNotFoundException ex){
            ex.printStackTrace();
        }
        
       // return DriverManager.getConnection(url, username, password);
       return DriverManager.getConnection("jdbc:mysql://localhost:3306/ITP4511_DB", "root", "");
    }
    
    public void createUserInfoTable(){
        Statement stmnt = null;
        Connection cnnct = null;
        try{
            cnnct = getConnection();
            stmnt = cnnct.createStatement();
            String sql
                    = "CREATE TABLE IF NOT EXISTS userInfo ("
                    + "Id varchar(5) NOT NULL,"
                    + "username varchar(25) NOT NULL,"
                    + "password varchar(25) NOT NULL,"
                    + "PRIMARY KEY (Id)"
                    + ")";
            stmnt.execute(sql);
            stmnt.close();
            cnnct.close();
        }catch(SQLException ex){
            while(ex != null){
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        }catch(IOException ex){
            ex.printStackTrace();
        }
        
    }
    public boolean addUserInfo(String id, String user, String pwd){
        Connection cnnct = null;
        PreparedStatement pStmnt = null;
        boolean isSuccess = false;
        try{
            cnnct = getConnection();
            
            //String preQueryStatement = "INSERT INTO USERINFO VALUES (?,?,?,?)";
            String preQueryStatement = "INSERT INTO APP.USERINFO (ID, USERNAME, PASSWORD)"
                    + "VALUES ('1', 'abc', '123')";
//            pStmnt = cnnct.prepareStatement(preQueryStatement);
//            pStmnt.setString(1, id);
//            pStmnt.setString(2, user);
//            pStmnt.setString(3, pwd);
            System.out.print(user + " is added.\n");
            int rowCount = pStmnt.executeUpdate();
            if(rowCount >= 1){
                isSuccess = true;
            }
            pStmnt.close();
            cnnct.close();
            
        }catch(SQLException ex){
            while(ex != null){
                ex.printStackTrace();
                ex = ex.getNextException();
                
            }
        }catch(IOException ex){
            ex.printStackTrace();
        }
        return isSuccess;
    }
    public boolean isValidUser(String user, String pwd, String type){
        Connection cnnct = null;
        PreparedStatement pStmnt = null;
        
        boolean isValid = false;
        try{
            String preQueryStatement = null;
            switch(type){
                case "student":
                    preQueryStatement = "SELECT * FROM STUDENT WHERE studentId=? AND PASSWORD=?";
                    break;
                case "teacher":
                    preQueryStatement = "SELECT * FROM TEACHER WHERE teacherAc=? AND PASSWORD=?";
                    break;
                case "admin":
                    preQueryStatement = "SELECT * FROM ADMINISTRATOR WHERE administratorAc=? AND PASSWORD=?";
                    break;
            }
            
            cnnct = getConnection();
            pStmnt = cnnct.prepareStatement(preQueryStatement);
            pStmnt.setString(1, user);
            pStmnt.setString(2, pwd);
            ResultSet rs = null;
            rs = pStmnt.executeQuery();
            if(rs.next()){
                isValid = true;
            } 
        }catch(SQLException ex){
            while(ex != null){
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        }catch(IOException ex){
            ex.printStackTrace();
        }
        return isValid;
    }
    public Student queryStudentById(String id){
        Connection cnnct = null;
        PreparedStatement pStmnt = null;
        
        Student stuBean = null;
        try{
            cnnct = getConnection();
            String preQueryStatement = "SELECT * FROM Student WHERE studentId=?";
            pStmnt = cnnct.prepareStatement(preQueryStatement);
            pStmnt.setString(1, id);
            ResultSet rs = null;
            rs = pStmnt.executeQuery();
            if(rs.next()){
                stuBean = new Student();
                stuBean.setFirstName(rs.getString("firstName"));
                stuBean.setLastName(rs.getString("lastName"));
                stuBean.setStudentClass(rs.getString("class"));
            }
        }catch(SQLException ex){
            while(ex != null){
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        }catch(IOException ex){
            ex.printStackTrace();
        }
        return stuBean;
    }
    public Teacher queryTeacherById(String id){
        Connection cnnct = null;
        PreparedStatement pStmnt = null;
        
        Teacher teaBean = null;
        try{
            cnnct = getConnection();
            String preQueryStatement = "SELECT * FROM Teacher WHERE teacherAc=?";
            pStmnt = cnnct.prepareStatement(preQueryStatement);
            pStmnt.setString(1, id);
            ResultSet rs = null;
            rs = pStmnt.executeQuery();
            if(rs.next()){
                teaBean = new Teacher();
                teaBean.setUserId(rs.getString("teacherId"));
                teaBean.setFirstName(rs.getString("firstName"));
                teaBean.setLastName(rs.getString("lastName"));
            }
        }catch(SQLException ex){
            while(ex != null){
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        }catch(IOException ex){
            ex.printStackTrace();
        }
        return teaBean;
    }
}
