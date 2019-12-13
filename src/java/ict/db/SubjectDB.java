package ict.db;

import ict.bean.SubjectBean;
import ict.bean.Phone;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SubjectDB {
    private ArrayList<SubjectBean> subjects = null;
    private String url = "";
    private String username = "";
    private String password = "";
    
    public SubjectDB(String dburl, String dbUser, String dbPassword){
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

