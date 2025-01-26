package org.example.config;

import com.fasterxml.jackson.databind.JsonNode;
import org.example.util.Json;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ConfigurationManger {
    private static ConfigurationManger myConfigurationManger;
    private static Configuration myCurrentConfiguration;
    private ConfigurationManger(){
    }
    public static ConfigurationManger getInstance(){
        if(myConfigurationManger==null)
        {
            myConfigurationManger= new ConfigurationManger();
        }
        return myConfigurationManger;
    }

    public void loadConfigFile(String filePath) throws IOException {
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(filePath);

        }catch (FileNotFoundException e){
            throw new FileNotFoundException("Didn't find the config file");
        }
        StringBuffer sBuffer  = new StringBuffer();
        int i;
        try {
            while(( i  = fileReader.read())!=-1){
                sBuffer.append((char)i);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        JsonNode conf = null;
        try{
            conf=Json.parse(sBuffer.toString());
        }
        catch (IOException e){
            throw new RuntimeException("Error parsing the config file ");
        }
        try {
            myCurrentConfiguration = Json.fromJson(conf,Configuration.class);
        } catch (IOException e) {
            throw new RuntimeException("Error parsing the config file internal");
        }
    }
    public Configuration getCurrentConfiguratoin() throws Exception {
        if(myCurrentConfiguration==null){
            throw new Exception("no Current Config");
        }
        return myCurrentConfiguration;
    }

}
