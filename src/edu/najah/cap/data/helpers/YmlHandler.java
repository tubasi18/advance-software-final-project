package edu.najah.cap.data.helpers;


import org.yaml.snakeyaml.Yaml;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Map;

public class YmlHandler {
    private YmlHandler() {}

    private static Map<String, Object> init() throws FileNotFoundException {
        Map<String, Object> data;
        InputStream inputStream = new FileInputStream( "src/resources/config.yml");
        Yaml yml = new Yaml();
        data = yml.load(inputStream);
        return data;
    }

    public static String getValue(String key) throws FileNotFoundException {
        return init().get(key).toString();
    }
}