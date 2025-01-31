package utils;

import org.testng.Reporter;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyManager {

    public static final String APPLICATION_FILE_PATH=System.getProperty("user.dir")+"/src/test/resources/config/application.properties";


    public static String getApplicationData(String key)
    {

        String value = "";
        FileInputStream fis = null;
        try {
            Properties prop = new Properties();
            File runtimeFiles = new File(APPLICATION_FILE_PATH);
            if (runtimeFiles.exists()) {
                fis = new FileInputStream(runtimeFiles);
                prop.load(fis);
                value = prop.getProperty(key);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (fis != null) {
                    fis.close();
                }
            } catch (IOException e) {
            }
        }
        return value;
    }

}
