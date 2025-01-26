package org.example;

import org.example.config.Configuration;
import org.example.config.ConfigurationManger;
import org.example.server.Server;

public class Main {
    public static void main(String[] args) throws Exception {
        Server server = new Server();
        server.start();
    }
}