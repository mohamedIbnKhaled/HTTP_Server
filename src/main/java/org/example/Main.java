package org.example;

import com.fasterxml.jackson.databind.JsonNode;
import org.example.config.Configuration;
import org.example.config.ConfigurationManger;
import org.example.util.Json;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("start testing the configManger ");
        ConfigurationManger.getInstance().loadConfigFile("src\\main\\resources\\http.json");
        Configuration conf = ConfigurationManger.getInstance().getCurrentConfiguratoin();
        System.out.println("port = " + conf.getPort());


    }
}