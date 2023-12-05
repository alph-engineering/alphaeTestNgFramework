package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadData {
    public static Properties property = new Properties();
    public static Properties propertyConfig = property;
    public static Properties propertyShip = property;
    public static Properties propertyPay = property;

    public ReadData(){


        try {
            FileInputStream fis1 = new FileInputStream(System.getProperty("user.dir")+ File.separator+"resources"+File.separator+"testdata"+File.separator+"shipping.properties");
            FileInputStream fis2 = new FileInputStream(System.getProperty("user.dir")+ File.separator+"resources"+File.separator+"testdata"+File.separator+"payment.properties");
            property.load(fis1);
            property.load(fis2);
        } catch(FileNotFoundException e) {
            e.printStackTrace();
        } catch(IOException e1) {
            e1.printStackTrace();
        }

    }
    String getUser = ReadData.propertyShip.getProperty("userName"); // String (Another layer of code between property)
    public String getUser(){ // Method (Another layer of code between property)
        return propertyShip.getProperty("userName");
    }



}
