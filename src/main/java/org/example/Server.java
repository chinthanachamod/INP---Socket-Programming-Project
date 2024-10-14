package org.example;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/*
public class Server {
    public static void main(String[] args) {
        try {
            //server socket
            ServerSocket serverSocket = new ServerSocket(3000);

            //local socket
            Socket socket = serverSocket.accept();
            System.out.println("Client Accepted");

            //data reading option
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());

            //sout
            String message = dataInputStream.readUTF();
            System.out.println(message);

            String message1 = "Server side message";

            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
            dataOutputStream.writeUTF(message1);
            dataOutputStream.flush();

            //connection closed
            socket.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}*/



public class Server {
    public static void main(String[] args) {
        try {
            // server socket
            ServerSocket serverSocket = new ServerSocket(3000);

            // accept client connection
            Socket socket = serverSocket.accept();
            System.out.println("Client Accepted");

            // Create input and output streams
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
            Scanner scanner = new Scanner(System.in);

            while (true) {
                // Receive message from the client
                String clientMessage = dataInputStream.readUTF();
                System.out.println("Client: " + clientMessage);

                if (clientMessage.equals("exit")) {
                    System.out.println("Exit from the System.............");
                    break;
                }

                // Send message to the client
                System.out.print("Enter message for the client: ");
                String serverMessage = scanner.nextLine();
                dataOutputStream.writeUTF(serverMessage);
                dataOutputStream.flush();
            }

            // close the connection
            socket.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
