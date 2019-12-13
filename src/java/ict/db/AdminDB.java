package ict.db;

import ict.bean.AdminBean;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AdminDB {
    private ArrayList<AdminBean> admins = null;
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

        public ArrayList queryAdmin(){
        ArrayList<AdminBean> list = new ArrayList();
        Connection cnnct = null;
        PreparedStatement pStmnt = null;
        
        AdminBean ad = null;
        try{
            cnnct = getConnection();
            String preQueryStatement = "SELECT * FROM administrator";
            pStmnt = cnnct.prepareStatement(preQueryStatement);
            ResultSet rs = null;
            rs = pStmnt.executeQuery();
            while(rs.next()){
                ad = new AdminBean();
                ad.setId(rs.getString("administratorId"));
                ad.setAc(rs.getString("administratorAc"));
                ad.setPw(rs.getString("password"));
                ad.setFirstName(rs.getString("firstName"));
                ad.setLastName(rs.getString("lastName"));
                System.out.print("Administrator ID: " + rs.getString("administratorId") + "\n");
                System.out.print("Administrator Account: " + rs.getString("administratorAc") + "\n");
                System.out.print("Password: " + rs.getString("password") + "\n");
                System.out.print("FirstName: " + rs.getString("firstName") + "\n");
                System.out.print("LastName: " + rs.getString("lastName") + "\n");
                list.add(ad);
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
    
        public boolean delAdmin(String id){
        Connection cnnct = null;
        PreparedStatement pStmnt = null;
        boolean isSuccess = false;
        try{
            cnnct = getConnection();
            String preQueryStatement = "DELETE FROM administrator WHERE administratorId=?";
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
    
    public AdminBean queryAdminById(String id){        
        Connection cnnct = null;
        PreparedStatement pStmnt = null;        
        AdminBean ad = null;
        try{
            cnnct = getConnection();
            String preQueryStatement = "SELECT * FROM administrator WHERE administratorId=?";
            pStmnt = cnnct.prepareStatement(preQueryStatement);
            pStmnt.setString(1, id);
            ResultSet rs = null;
            rs = pStmnt.executeQuery();
            if (rs.next()) {
                ad = new AdminBean();
                ad.setId(rs.getString(1));
                ad.setAc(rs.getString(2));
                ad.setPw(rs.getString(3));
                ad.setFirstName(rs.getString(4));
                ad.setLastName(rs.getString(5));
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
        return ad;
    }        
        
    public int editAdmin(AdminBean ad) {
        Connection cnnct = null;
        PreparedStatement pStmnt = null;
        try {           
            cnnct = getConnection();
            String preQueryStatement = "UPDATE administrator SET administratorAc=? ,password=? ,firstName=?, lastName=? WHERE administratorId=?";
            pStmnt = cnnct.prepareStatement(preQueryStatement);
            pStmnt.setString(1, ad.getAc());
            pStmnt.setString(2, ad.getPw());
            pStmnt.setString(3, ad.getFirstName());
            pStmnt.setString(4, ad.getLastName());
            pStmnt.setString(5, ad.getId());
            //Statement s = cnnct.createStatement();
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