package ict.bean;
 
import java.io.Serializable;
import java.util.Date;
public class Lesson implements Serializable{

    private String id;
    private String date;
    private String stuClass;
    public Lesson(String id, String date, String stuClass) {
        this.id = id;
        this.date = date;
        this.stuClass = stuClass;
    } 
    public Lesson(){
        
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
    public String getStuClass(){
        return stuClass;
    }
    public void setStuClass(String stuClass){
        this.stuClass = stuClass;
    }
}