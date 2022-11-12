package com.marcin.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ResourcesUtil {

    private static final String MAIN_PROPERTIES = "src/main/resources/main.properties";
    private static Properties properties = new Properties();

    public static String getStringResource(String key) {
//        Properties properties = new Properties();
//        String mainProperties = "src/main/resources/main.properties";

        try {
            properties.load(new FileInputStream(MAIN_PROPERTIES));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return properties.getProperty(key);
    }

    public static int getIntResource(String key) {
        try {
            properties.load(new FileInputStream(MAIN_PROPERTIES));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return Integer.parseInt(properties.getProperty(key));
    }

}


