package org.example.server;

import org.example.config.Configuration;
import org.example.config.ConfigurationManger;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public void start() throws Exception {
        ConfigurationManger.getInstance().loadConfigFile("src\\main\\resources\\http.json");
        Configuration conf = ConfigurationManger.getInstance().getCurrentConfiguration();
        System.out.println("port = " + conf.getPort());
        try {
            ServerSocket serverSocket = new ServerSocket(conf.getPort());
            Socket socket = serverSocket.accept();
            InputStream inputStream = socket.getInputStream();
            String html = "<html><body><h1>Hello, World!</h1></body></html>";
            int contentLength = html.length();
            String httpResponse =
                    "HTTP/1.1 200 OK\r\n" +
                            "Content-Type: text/html\r\n" +
                            "Content-Length: " + contentLength + "\r\n" +
                            "\r\n" +
                            html;
            OutputStream outputStream = socket.getOutputStream();
            outputStream.write(httpResponse.getBytes());
            outputStream.flush();
            inputStream.close();
            outputStream.close();
            socket.close();
            serverSocket.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
