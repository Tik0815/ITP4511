package ict.db;

import ict.bean.Admin;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AdminDB {
    private ArrayList<Admin> admins = null;
    private String url = "";
    private String username = "";
    private String password = "";
    
    public AdminDB(String dburl, String dbUser, String dbPassword){
        this.url = url;
        this.username = username;
        this.password = password;
        admins = new ArrayList();
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

    /*public ArrayList getAdmins(String user) {
        Connection cnnct = null;
        PreparedStatement pStmnt = null;
        admins.clear();
        try{
            String preQueryStatement = "SELECT * FROM ADMINISTRATOR WHERE studentId=?";
            cnnct = getConnection();
            pStmnt = cnnct.prepareStatement(preQueryStatement);
            pStmnt.setString(1, user);
            ResultSet rs = null;
                rs = pStmnt.executeQuery();
                while(rs.next()){
                    System.out.println(rs.getString(1)+" "+rs.getString(2));
                    //subjects.add(new Subject(rs.getString(subjectID));
                    String preQueryStatement_getSubject = "SELECT * FROM SUBJECT WHERE subjectId=?";
                    PreparedStatement pStmnt_getSubject = cnnct.prepareStatement(preQueryStatement_getSubject);
                    pStmnt_getSubject.setString(1, rs.getString("subjectId"));
                    ResultSet rs_subject = null;
                        rs_subject = pStmnt_getSubject.executeQuery();
                        System.out.println(rs.getString(1)+" "+rs.getString(2));
                        if(rs_subject.next())
                            admins.add(new Admin(rs_subject.getString("subject"), rs.getString("subjectId")));
                } 
        }catch(SQLException ex){
            while(ex != null){
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        }catch(IOException ex){
            ex.printStackTrace();
        }    
        return this.admins;
    }*/
    
    public boolean createAdmin(String id, String ac, String pw, String fname, String lname) {
       Connection cnnct = null;
        PreparedStatement pStmnt = null;
        boolean isSuccess = false;
        try{
            cnnct = getConnection();
            String preQueryStatement = "INSERT INTO administrator VALUES (?,?,?,?,?)";
            pStmnt = cnnct.prepareStatement(preQueryStatement);
            pStmnt.setString(1, id);
            pStmnt.setString(2, ac);
            pStmnt.setString(3, pw);
            pStmnt.setString(4, fname);
            pStmnt.setString(5, lname);
            System.out.print(fname + " is added.\n");
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
    
    public boolean createStudent(String id, String pw, String fname, String lname, String studentClass) {
       Connection cnnct = null;
        PreparedStatement pStmnt = null;
        boolean isSuccess = false;
        try{
            cnnct = getConnection();
            String preQueryStatement = "INSERT INTO student VALUES (?,?,?,?,?)";
            pStmnt = cnnct.prepareStatement(preQueryStatement);
            pStmnt.setString(1, id);
            pStmnt.setString(2, pw);
            pStmnt.setString(3, fname);
            pStmnt.setString(4, lname);
            pStmnt.setString(5, studentClass);
            System.out.print(fname + " is added.\n");
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
    
    public boolean createTeacher(String id, String ac, String pw, String fname, String lname, String phone, String email) {
        Connection cnnct = null;
        PreparedStatement pStmnt = null;
        boolean isSuccess = false;
        try{
            cnnct = getConnection();
            String preQueryStatement = "INSERT INTO teacher VALUES (?,?,?,?,?,?,?)";
            pStmnt = cnnct.prepareStatement(preQueryStatement);
            pStmnt.setString(1, id);
            pStmnt.setString(2, ac);
            pStmnt.setString(3, pw);
            pStmnt.setString(4, fname);
            pStmnt.setString(5, lname);
            pStmnt.setString(6, phone);
            pStmnt.setString(7, email);
            System.out.print(fname + " is added.\n");
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
    

  }