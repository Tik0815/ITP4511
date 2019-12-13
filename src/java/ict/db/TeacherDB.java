package ict.db;

import ict.bean.SubjectBean;
import ict.bean.TeacherBean;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TeacherDB {
    private ArrayList<SubjectBean> subjects = null;
    private String url = "";
    private String username = "";
    private String password = "";
    
    public TeacherDB(String dburl, String dbUser, String dbPassword){
        this.url = url;
        this.username = username;
        this.password = password;
        subjects = new ArrayList();
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
    
    public ArrayList queryTeacher(){
        ArrayList<TeacherBean> list = new ArrayList();
        Connection cnnct = null;
        PreparedStatement pStmnt = null;
        
        TeacherBean tb = null;
        try{
            cnnct = getConnection();
            String preQueryStatement = "SELECT * FROM teacher";
            pStmnt = cnnct.prepareStatement(preQueryStatement);
            ResultSet rs = null;
            rs = pStmnt.executeQuery();
            while(rs.next()){
                tb = new TeacherBean();
                tb.setId(rs.getString("teacherId"));
                tb.setAc(rs.getString("teacherAc"));
                tb.setPw(rs.getString("password"));
                tb.setFirstName(rs.getString("firstName"));
                tb.setLastName(rs.getString("lastName"));
                tb.setPhone(rs.getString("phoneNumber"));
                tb.setEmail(rs.getString("emailAddress"));
                System.out.print("Teacher ID: " + rs.getString("teacherId") + "\n");
                System.out.print("Teacher Account: " + rs.getString("teacherAc") + "\n");
                System.out.print("Password: " + rs.getString("password") + "\n");
                System.out.print("FirstName: " + rs.getString("firstName") + "\n");
                System.out.print("LastName: " + rs.getString("lastName") + "\n");
                System.out.print("Phone Number: " + rs.getString("phoneNumber") + "\n");
                System.out.print("Email Address: " + rs.getString("emailAddress") + "\n");
                list.add(tb);
            }
        }catch(SQLException ex){
            while(ex != null){
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        }catch(IOException ex){
            ex.printStackTrace();
        }
        return list;
    }
    
    public boolean delTeacher(String id){
        Connection cnnct = null;
        PreparedStatement pStmnt = null;
        boolean isSuccess = false;
        try{
            cnnct = getConnection();
            String preQueryStatement = "DELETE FROM teacher WHERE teacherId=?";
            pStmnt = cnnct.prepareStatement(preQueryStatement);
            pStmnt.setString(1, id);
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
    
