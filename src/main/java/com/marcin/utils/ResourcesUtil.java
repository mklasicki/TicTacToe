package com.marcin.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ResourcesUtil {

    public static String getResource(String key) {
        Properties properties = new Properties();
        String mainProperties = "src/main/resources/main.properties";

        try {
            properties.load(new FileInputStream(mainProperties));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return properties.getProperty(key);
    }

}

