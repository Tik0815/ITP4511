package ict.bean;
 
import java.io.Serializable;
import java.util.Date;
public class Lesson implements Serializable{

    private String id;
    private String date;
    public Lesson(String id, String date) {
        this.id = id;
        this.date = date;
    } 
    
    public String getId(){
      return id;
   }
   public void setId(String id){
       this.id = id;
   }
    public String getDate(){
        return date;
    }
    public void setDate(String date){
        this.date = date;
    }
}