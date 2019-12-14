package ict.db;

import ict.bean.StudentBean;
import ict.bean.SubjectBean;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class StudentDB {
    private ArrayList<SubjectBean> subjects = null;
    private String url = "";
    private String username = "";
    private String password = "";
    
    public StudentDB(String dburl, String dbUser, String dbPassword){
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
    
    public ArrayList queryStudent(){
        ArrayList<StudentBean> list = new ArrayList();
        Connection cnnct = null;
        PreparedStatement pStmnt = null;
        
        StudentBean sb = null;
        try{
            cnnct = getConnection();
            String preQueryStatement = "SELECT * FROM student";
            pStmnt = cnnct.prepareStatement(preQueryStatement);
            ResultSet rs = null;
            rs = pStmnt.executeQuery();
            while(rs.next()){
                sb = new StudentBean();
                sb.setId(rs.getString("studentId"));
                sb.setPw(rs.getString("password")); 
                sb.setFirstName(rs.getString("firstName"));
                sb.setLastName(rs.getString("lastName"));
                sb.setStudentClass(rs.getString("class"));
                System.out.print("Student ID: " + rs.getString("studentId") + "\n");
                System.out.print("Password: " + rs.getString("password") + "\n");
                System.out.print("FirstName: " + rs.getString("firstName") + "\n");
                System.out.print("LastName: " + rs.getString("lastName") + "\n");
                System.out.print("Class: " + rs.getString("class") + "\n");
                list.add(sb);
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
    
        public StudentBean queryStudentById(String id){        
        Connection cnnct = null;
        PreparedStatement pStmnt = null;        
        StudentBean st = null;
        try{
            cnnct = getConnection();
            String preQueryStatement = "SELECT * FROM student WHERE studentId=?";
            pStmnt = cnnct.prepareStatement(preQueryStatement);
            pStmnt.setString(1, id);
            ResultSet rs = null;
            rs = pStmnt.executeQuery();
            if (rs.next()) {
                st = new StudentBean();
                st.setId(rs.getString(1));
                st.setPw(rs.getString(2));
                st.setFirstName(rs.getString(3));
                st.setLastName(rs.getString(4));
                st.setStudentClass(rs.getString(5));
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
        return st;
    }
        
    public int editStudent(StudentBean st) {
        Connection cnnct = null;
        PreparedStatement pStmnt = null;
        try {           
            cnnct = getConnection();
            String preQueryStatement = "UPDATE student SET password=? ,firstName=?, lastName=?, class=? WHERE studentId=?";
            pStmnt = cnnct.prepareStatement(preQueryStatement);
            pStmnt.setString(1, st.getPw());         
            pStmnt.setString(2, st.getFirstName());
            pStmnt.setString(3, st.getLastName());
            pStmnt.setString(4, st.getStudentClass());
            pStmnt.setString(5, st.getId());
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
    
    public boolean delStudent(String id){
        Connection cnnct = null;
        PreparedStatement pStmnt = null;
        boolean isSuccess = false;
        try{
            cnnct = getConnection();
            String preQueryStatement = "DELETE FROM student WHERE studentId=?";
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
//    public void fillSubject() {
//        Connection cnnct = null;
//        PreparedStatement pStmnt = null;
//        preQueryStatement = "SELECT * FROM STUDENT_HAS_SUBJECT WHERE studentId=?";
//        subjects.add(new Brand("HTC"));
//        subjects.add(new Brand("IPHONE"));
//        subjects.add(new Brand("SAMSUNG"));
//    }
    public ArrayList getSubjects(String user) {
        Connection cnnct = null;
        PreparedStatement pStmnt = null;
        subjects.clear();
        try{
            String preQueryStatement = "SELECT * FROM STUDENT_HAS_SUBJECT WHERE studentId=?";
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
                            subjects.add(new SubjectBean(rs_subject.getString("subject"), rs.getString("subjectId")));
                } 
        }catch(SQLException ex){
            while(ex != null){
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        }catch(IOException ex){
            ex.printStackTrace();
        }    
//        subjects.add(new Brand("HTC"));
//        subjects.add(new Brand("IPHONE"));
//        subjects.add(new Brand("SAMSUNG"));
        return this.subjects;
    }
    
    public void addSubject(SubjectBean s) {    this.subjects.add(s);  }
    
//    public ArrayList<Phone> getPhonesByBrand(String brand) {
//
//        ArrayList<Phone> phones = new ArrayList<Phone>();
//        if (brand.equalsIgnoreCase("HTC")) {
//          phones.add(new Phone("HTC smart", "img/htcsmartsmall.png", 200));
//          phones.add(new Phone("HTC One X", "img/htconexsmall.png", 200));
//        } else if (brand.equalsIgnoreCase("IPHONE")) {
//          phones.add(new Phone("Iphone 4", "img/iphone4small.png", 99));
//          phones.add(new Phone("Iphone 4s", "img/iphone4ssmall.png", 199));
//          phones.add(new Phone("Iphone 5", "img/iphone5small.png", 299));
//        } else if (brand.equalsIgnoreCase("SAMSUNG")) {
//          phones.add(new Phone("galaxy S3", "img/s3.png", 299));
//          phones.add(new Phone("galaxy S4", "img/s4.png", 399));
//        }
//        return phones;
//    }
  }