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
    
    public TeacherBean queryTeacherById(String id){        
        Connection cnnct = null;
        PreparedStatement pStmnt = null;        
        TeacherBean te = null;
        try{
            cnnct = getConnection();
            String preQueryStatement = "SELECT * FROM teacher WHERE teacherId=?";
            pStmnt = cnnct.prepareStatement(preQueryStatement);
            pStmnt.setString(1, id);
            ResultSet rs = null;
            rs = pStmnt.executeQuery();
            if (rs.next()) {
                te = new TeacherBean();
                te.setId(rs.getString(1));
                te.setAc(rs.getString(2));
                te.setPw(rs.getString(3));
                te.setFirstName(rs.getString(4));
                te.setLastName(rs.getString(5));
                te.setPhone(rs.getString(6));
                te.setEmail(rs.getString(7));
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
        return te;
    }        
        
    public int editTeacher(TeacherBean te) {
        Connection cnnct = null;
        PreparedStatement pStmnt = null;
        try {           
            cnnct = getConnection();
            String preQueryStatement = "UPDATE teacher SET teacherAc=? ,password=? ,firstName=?, lastName=?, phoneNumber=?, emailAddress=? WHERE teacherId=?";
            pStmnt = cnnct.prepareStatement(preQueryStatement);
            pStmnt.setString(1, te.getAc());
            pStmnt.setString(2, te.getPw());
            pStmnt.setString(3, te.getFirstName());
            pStmnt.setString(4, te.getLastName());
            pStmnt.setString(5, te.getPhone());
            pStmnt.setString(6, te.getEmail());
            pStmnt.setString(7, te.getId());
            int rs = pStmnt.executeUpdate();
            return rs;
        } catch (SQLException ex) {
            while (ex != null) {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (pStmnt != null) {
                try {
                    pStmnt.close();
                } catch (SQLException e) {
                }
            }
            if (cnnct != null) {
                try {
                    cnnct.close();
                } catch (SQLException sqlEx) {
                }
            }
        }
        return 0;
    }
 
    }
    
