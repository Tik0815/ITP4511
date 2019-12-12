package ict.bean;
 
import java.io.Serializable;

public class Subject implements Serializable{
   private String name;
   private String id;
   public Subject(String name, String id) {
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
