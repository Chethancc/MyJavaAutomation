package fileReaders;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by chethanc on 23/2/20.
 */
public class PropertiesReader {

    public String localFilePath = "/Users/chethanc/Documents/ChethanProject/MyJavaAutomation/src/main/resources/application.properties";
    public String jenkinsFilePath = "";
    Properties properties;
    File file;

    public PropertiesReader() {

        properties = new Properties();
        try {
            file = new File(jenkinsFilePath);
            if (file.exists()) {
                properties.load(new FileInputStream(file));

            } else {
                file = new File(localFilePath);
                properties.load(new FileInputStream(file));

            }
        }catch (IOException fne){
            System.out.println("Not able to load file");
        }
        for (String key : properties.stringPropertyNames())
        {
            System.setProperty(key,properties.getProperty(key));
        }
        //if()
    }
}
