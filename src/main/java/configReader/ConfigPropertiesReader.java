package configReader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigPropertiesReader {

    private final Properties properties;

    public ConfigPropertiesReader()
    {
        BufferedReader reader;
        String propertyFilePath = "config\\config.properties";
        try {
            reader = new BufferedReader(new FileReader(propertyFilePath));
            properties = new Properties();
            try {
                properties.load(reader);
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
        }
    }

    public String getBaseURI()
    {
        String baseURI = properties.getProperty("baseURI");
        if(baseURI != null)
            return baseURI;
        else
            throw new RuntimeException("baseURI not specified in the config.properties file.");
    }

    public String getUsersPathParam()
    {
        String usersPathParam = properties.getProperty("usersPathParam");
        if(usersPathParam != null)
            return usersPathParam;
        else
            throw new RuntimeException("usersPathParam not specified in the config.properties file.");
    }

    public String getUnknownPathParam()
    {
        String unknownPathParam = properties.getProperty("unknownPathParam");
        if(unknownPathParam != null)
            return unknownPathParam;
        else
            throw new RuntimeException("unknownPathParam not specified in the config.properties file.");
    }

    public String getRegisterPathParam()
    {
        String registerPathParam = properties.getProperty("registerPathParam");
        if(registerPathParam != null)
            return registerPathParam;
        else
            throw new RuntimeException("registerPathParam not specified in the config.properties file.");
    }

    public String getLoginPathParam()
    {
        String loginPathParam = properties.getProperty("loginPathParam");
        if(loginPathParam != null)
            return loginPathParam;
        else
            throw new RuntimeException("loginPathParam not specified in the config.properties file.");
    }
}
