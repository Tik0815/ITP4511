package ict.bean;
 
import java.io.Serializable;
import java.util.Date;
import ict.bean.Lesson;

public class Attendance implements Serializable{
   private String id;
   private Lesson lesson;
   private Boolean isAttend;
   public Attendance(String id, Lesson lesson, Boolean isAttend) {
       this.id = id;
       this.lesson = lesson;
       this.isAttend = isAttend;
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
