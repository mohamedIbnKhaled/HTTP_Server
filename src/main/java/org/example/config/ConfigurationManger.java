package org.example.config;

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
    public void loadConfigFile(String filePath){

    }
    public Configuration getCurrentConfiguratoin(){
        return myCurrentConfiguration;
    }

}
