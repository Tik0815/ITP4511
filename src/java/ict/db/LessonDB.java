package ict.db;

import ict.bean.Subject;
import ict.bean.Lesson;
import ict.bean.Attendance;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

public class LessonDB {
    private ArrayList lessons = null;
    private String url = "";
    private String username = "";
    private String password = "";
    
    public LessonDB(String dburl, String dbUser, String dbPassword){
        this.url = url;
        this.username = username;
        this.password = password;
        lessons = new ArrayList();
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
    public ArrayList getAttendance(String user, String subject) {
        Connection cnnct = null;
        PreparedStatement pStmnt = null;
        lessons = new ArrayList<Attendance>();
        try{
            String preQueryStatement = "SELECT * FROM Attendance WHERE studentId=?";
            cnnct = getConnection();
            pStmnt = cnnct.prepareStatement(preQueryStatement);
            //pStmnt.setString(1, user);
            
            pStmnt.setString(1, user);
            
            System.out.println(pStmnt);
            ResultSet rs = null;
                rs = pStmnt.executeQuery();
                int i = 1;
                while(rs.next()){
                    System.out.println(rs.getString(1)+" "+rs.getString(2));
                    String attendId = rs.getString(1);
                    String lessonId = rs.getString(2);
                    Boolean isAttend = rs.getBoolean(4);
                    //subjects.add(new Subject(rs.getString(subjectID));
                    String preQueryStatement_getLesson = "SELECT * FROM Lesson WHERE subjectId=?";
                    PreparedStatement pStmnt_getLesson = cnnct.prepareStatement(preQueryStatement_getLesson);
                    pStmnt_getLesson.setString(1, subject);
                    
                    System.out.println(pStmnt_getLesson);
                    ResultSet rs_lesson = null;
                        rs_lesson = pStmnt_getLesson.executeQuery();
                        String date;
                        String stuClass;
                        //if(rs_lesson.next()){
                        if(rs_lesson.absolute(i)){
                            date = rs_lesson.getString("date");
                            stuClass = rs_lesson.getString("class"); 
                            Lesson lesson = new Lesson(lessonId, date, stuClass);
                            lessons.add(new Attendance(attendId, lesson, isAttend));
                        }
                        i++;
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
        return this.lessons;
    }
    public ArrayList getTeacherLessons(String user, String subject) {
        Connection cnnct = null;
        PreparedStatement pStmnt = null;
        lessons = new ArrayList<Lesson>();
        try{
            String preQueryStatement = "SELECT * FROM Lesson WHERE teacherId=? AND subjectId=?";
            cnnct = getConnection();
            pStmnt = cnnct.prepareStatement(preQueryStatement);
            
            pStmnt.setString(1, user);
            pStmnt.setString(2, subject);
            System.out.println(pStmnt);
            ResultSet rs = null;
                rs = pStmnt.executeQuery();
                int i = 1;
                while(rs.next()){
                    
                    String date = rs.getString("date");
                    String lessonId = rs.getString("lessonId");
                    String stuClass = rs.getString("class");
                    Lesson lesson = new Lesson(lessonId, date, stuClass);
                    lessons.add(lesson);
                        
                } 
        }catch(SQLException ex){
            while(ex != null){
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        }catch(IOException ex){
            ex.printStackTrace();
        }    
        return this.lessons;
    }
    public Lesson queryLessonById(String id) {
        Connection cnnct = null;
        PreparedStatement pStmnt = null;
        Lesson lesson = new Lesson();
        try{
            String preQueryStatement = "SELECT * FROM Lesson WHERE lessonId=?";
            cnnct = getConnection();
            pStmnt = cnnct.prepareStatement(preQueryStatement);
            
            pStmnt.setString(1, id);
            System.out.println(pStmnt);
            ResultSet rs = null;
                rs = pStmnt.executeQuery();
                if(rs.next()){
                    
                    String date = rs.getString("date");
                    String lessonId = rs.getString("lessonId");
                    String stuClass = rs.getString("class");
                    lesson = new Lesson(lessonId, date, stuClass);
                        
                } 
        }catch(SQLException ex){
            while(ex != null){
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        }catch(IOException ex){
            ex.printStackTrace();
        }    
        return lesson;
    }
  }

