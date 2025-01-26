package org.example;

import org.example.config.Configuration;
import org.example.config.ConfigurationManger;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("start testing the configManger ");
        ConfigurationManger.getInstance().loadConfigFile("src\\main\\resources\\http.json");
        Configuration conf = ConfigurationManger.getInstance().getCurrentConfiguration();
        System.out.println("port = " + conf.getPort());


    }
}