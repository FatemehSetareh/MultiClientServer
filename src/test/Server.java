package test;

import java.io.*;
import java.net.*;

/**
 * Created by ${Dotin} on ${4/25/2015}.
 */
public class Server extends Thread {

    private ServerSocket serverSocket;
    private Socket server;
    private RandomAccessFile serverLog;

    public Server(int portNumber) throws IOException {
        serverSocket = new ServerSocket(portNumber);
        // serverLog = new RandomAccessFile(new File("serverLog.xml"), "rw");
    }

    @Override
    public void run() {
        // MyJsonParser myJsonParser = new MyJsonParser(Main.jsonFilePath);
        // myJsonParser.parseJson();
        //  myJsonParser.updateJson();
        try {
            while (true) {
                System.out.println("Server : Waiting for client on port : " + serverSocket.getLocalPort());
                server = serverSocket.accept();
                System.out.println("Server : Got connection from : " + server.getInetAddress());
                //Client client = new Client(InetAddress.getLocalHost().getHostName(),Main.portNumber, server);
                //client.start();

//                /******jahate khandan az consul :D
//                BufferedReader serverReader = new BufferedReader(new InputStreamReader(server.getInputStream()));
//                PrintWriter serverWriter = new PrintWriter(server.getOutputStream());
//                serverWriter.println("Server : Welcome to my server");
//                serverWriter.flush();
//                String message = serverReader.readLine();
//                while (!(message == null || message.equalsIgnoreCase("exit"))) {
//                    System.out.println("Server : MessageReceived: " + message);
//                    serverWriter.println(message);
//                    serverWriter.flush();
//                    message = serverReader.readLine();
//                }

                byte[] myByteArray = new byte[1024];
                InputStream inputStream = server.getInputStream();
                FileOutputStream fileOutputStream = new FileOutputStream("response.xml");
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
                int bytesRead = inputStream.read(myByteArray, 0, myByteArray.length);
                bufferedOutputStream.write(myByteArray, 0, bytesRead);
                bufferedOutputStream.close();

                server.close();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}



