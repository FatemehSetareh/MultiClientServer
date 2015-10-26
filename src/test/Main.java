package test;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

/**
 * Created by ${Dotin} on ${4/25/2015}.
 */
public class Main {
    public static Integer portNumber = 1234;
    public static String ipAddress = "3.3.3.3";

    public static void main(String[] args) {

        try {
            Thread server = new Server(portNumber);
            server.start();
            Thread client = new Client(InetAddress.getLocalHost().getHostName(), portNumber, new Socket());
            client.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
