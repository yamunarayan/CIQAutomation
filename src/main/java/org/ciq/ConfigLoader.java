package org.ciq;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

public class ConfigLoader {

    public String getConfigValue(String key) {

        String configValue="";

        try{
            Properties properties = new Properties();
            properties.load(new FileReader("./src/main/resources/application.properties"));
            configValue=properties.get(key).toString();
        }
        catch (Exception e){
            System.out.println("unable to read from file");
        }

        return configValue;

    }
}
