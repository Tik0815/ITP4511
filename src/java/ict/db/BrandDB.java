package ict.db;

import ict.bean.Brand;
import ict.bean.Phone;
import java.util.ArrayList;

public class BrandDB {
    private ArrayList<Brand> brands = null;
    public BrandDB() {
        brands = new ArrayList();
        fillInfo();
    }
    public void fillInfo() {
        brands.add(new Brand("HTC"));
        brands.add(new Brand("IPHONE"));
        brands.add(new Brand("SAMSUNG"));
    }
    public ArrayList getBrands() {     return this.brands;  }
    
    public void addBrand(Brand b) {    this.brands.add(b);  }
    
    public ArrayList<Phone> getPhonesByBrand(String brand) {

        ArrayList<Phone> phones = new ArrayList<Phone>();
        if (brand.equalsIgnoreCase("HTC")) {
          phones.add(new Phone("HTC smart", "img/htcsmartsmall.png", 200));
          phones.add(new Phone("HTC One X", "img/htconexsmall.png", 200));
        } else if (brand.equalsIgnoreCase("IPHONE")) {
          phones.add(new Phone("Iphone 4", "img/iphone4small.png", 99));
          phones.add(new Phone("Iphone 4s", "img/iphone4ssmall.png", 199));
          phones.add(new Phone("Iphone 5", "img/iphone5small.png", 299));
        } else if (brand.equalsIgnoreCase("SAMSUNG")) {
          phones.add(new Phone("galaxy S3", "img/s3.png", 299));
          phones.add(new Phone("galaxy S4", "img/s4.png", 399));
        }
        return phones;
    }
  }

