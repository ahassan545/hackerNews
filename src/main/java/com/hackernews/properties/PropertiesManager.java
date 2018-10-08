package com.hackernews.properties;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesManager {

    private Properties properties;

    public PropertiesManager(String fileName) throws IOException {
        properties = new Properties();
        InputStream inputStream = read(fileName);
        properties.load(inputStream);
    }

    public String getValue(String key) {
        return properties.getProperty(key);
    }

    private InputStream read(String fileName) {
        return getClass().getClassLoader().getResourceAsStream(fileName);
    }
}
