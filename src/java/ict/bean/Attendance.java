package ict.bean;
 
import java.io.Serializable;
import java.util.Date;
import ict.bean.Lesson;

public class Attendance implements Serializable{
   private String id;
   private Student stu;
   private Lesson lesson;
   private Boolean isAttend;
   public Attendance(String id, Lesson lesson, Boolean isAttend) {
       this.id = id;
       this.lesson = lesson;
       this.isAttend = isAttend;
   }
   public Attendance(){
       
   }
//   public Attendance(String id, Student stu, Boolean isAttend) {
//       this.stu = stu;
//       this.id = id;
//       this.isAttend = isAttend;
//   }
   public Student getStu(){
       return stu;
   }
   public void setStu(Student stu){
       this.stu = stu;
   }
   public Boolean getIsAttend(){
      return isAttend;
   }
   
   public void setIsAttend(Boolean isAttend){
       this.isAttend = isAttend;
   }
   public String getId(){
      return id;
   }
   
   public void setId(String id){
       this.id = id;
   }
   public Lesson getLesson(){
       return lesson;
   }
   public void setLesson(Lesson lesson){
       this.lesson = lesson;
   }
}
