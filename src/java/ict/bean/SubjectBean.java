package ict.bean;
 
import java.io.Serializable;

public class SubjectBean implements Serializable{
   private String name;
   private String id;
   public SubjectBean(String name, String id) {
       this.name = name;
       this.id = id;
   }
   public String getName(){
      return name;
   }
   
   public void setName(String Name){
       this.name = name;
   }
   public String getId(){
      return id;
   }
   
   public void setId(String id){
       this.id = id;
   }
}
