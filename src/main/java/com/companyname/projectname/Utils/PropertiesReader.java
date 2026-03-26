package com.companyname.projectname.Utils;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
public class PropertiesReader {
    public static String readKey(String key) {
        Properties p = new Properties(); //'Properties' is used to store and read key-value pairs.
        String user_dir = System.getProperty("user.dir");
        // -> C:\Users\DELL\IdeaProjects\ATB15xSeleniumAdvancedFramework
        String file_path = user_dir + "/src/main/resources/data.properties";
        // -> C:\Users\DELL\IdeaProjects\ATB15xSeleniumAdvancedFramework\src\main\resources\data.properties
        try {
            FileInputStream fileInputStream = new FileInputStream(file_path);//FileInputStream is used to read data from a file
            p.load(fileInputStream);
        } catch (FileNotFoundException e) {//subclass of IOException
            throw new RuntimeException(e);
        } catch (IOException e) {//Input-Output exception
            throw new RuntimeException(e);
        }
        return p.getProperty(key);
    }
}