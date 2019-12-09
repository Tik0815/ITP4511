package ict.bean;
 
import java.io.Serializable;

public class Phone implements Serializable{

    private String name;
    private String img;
    private double price;
    public Phone(String name, String img, double price) {
        this.name = name;
        this.img = img;
        this.price = price;
    } 
    
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
    public void setImg(String img){
        this.img = img;
    }
    public String getImg(){
        return img;
    }
    public void setPrice(double price){
       this.price = price;
    }
    public double getPrice(){
        return price;
    }
    // 1. set up the corresponding properties
    // 2. prepare the getter and setter
    // 3. default constructor
    // 4. implements  Serializable
}
