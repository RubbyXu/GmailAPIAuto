package com.gmailapi.prop;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropInstance {
    private static Properties prop;
    private static final String PROP_FILE = "config/config.properties";

    public static Properties getPropInstance(){
        if (prop != null){
            return prop;
        }
        prop = getProperties(PROP_FILE);
        return prop;
    }

    private static Properties getProperties(String fileName){
        java.util.Properties prop = new java.util.Properties();
        InputStream input = PropInstance.class.getClassLoader().getResourceAsStream(fileName);
        try {
            prop.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return prop;
    }
}
