package ict.db;

import ict.bean.Attendance;
import ict.bean.Student;
import ict.bean.Subject;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AttendanceDB {
    private ArrayList<Attendance> students = null;
    private String url = "";
    private String username = "";
    private String password = "";
    
    public AttendanceDB(String dburl, String dbUser, String dbPassword){
        this.url = url;
        this.username = username;
        this.password = password;
        students = new ArrayList();
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
    
    
    public ArrayList getStudentsAttendance(String lessonId){
        Connection cnnct = null;
        PreparedStatement pStmnt = null;
        students.clear();
        try{
            String preQueryStatement = null;
            preQueryStatement = "SELECT * FROM Attendance WHERE lessonId=?";
            cnnct = getConnection();
            pStmnt = cnnct.prepareStatement(preQueryStatement);
            pStmnt.setString(1, lessonId);
            ResultSet rs = null;
                rs = pStmnt.executeQuery();
                while(rs.next()){
                    System.out.println(rs.getString(1)+" "+rs.getString(2));
                    //subjects.add(new Subject(rs.getString(subjectID));
                    String preQueryStatement_getStudentInfo = "SELECT * FROM Student WHERE studentId=?";
                    PreparedStatement pStmnt_getStudentInfo = cnnct.prepareStatement(preQueryStatement_getStudentInfo);
                    pStmnt_getStudentInfo.setString(1, rs.getString("studentId"));
                    ResultSet rs_student = null;
                        rs_student = pStmnt_getStudentInfo.executeQuery();
                        System.out.println(rs.getString(1)+" "+rs.getString(2));
                        Student studentInfo = new Student();
                        
                        while(rs_student.next()){
                            studentInfo.setFirstName(rs_student.getString("firstName"));
                            studentInfo.setLastName(rs_student.getString("lastName"));
                            studentInfo.setId(rs_student.getString("studentId"));
                            studentInfo.setStudentClass(rs_student.getString("class"));
                            Attendance attend = new Attendance();
                            attend.setStu(studentInfo);
                            attend.setIsAttend(rs.getBoolean("isAttend"));
                            students.add(attend);
                }       }
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
        return this.students;
    } 
  }