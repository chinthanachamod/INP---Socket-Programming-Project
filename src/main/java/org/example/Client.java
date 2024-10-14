package org.example;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

/*public class Client {
    public static void main(String[] args) {
        try {
            //remote socket
            Socket socket = new Socket("localhost", 3000);

            //request to the server
            String message = "This is client side message";

            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());         //data yawan
            // nisa data out put stream kyl gnnw
            dataOutputStream.writeUTF(message);
            dataOutputStream.flush();

            //send the data
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            String message1 = dataInputStream.readUTF();
            System.out.println(message1);

            //connection close
            socket.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}*/


public class Client {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            // connect to the server
            Socket socket = new Socket("localhost", 3000);

            // Create input and output streams
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

            while (true) {
                // Send message to the server
                System.out.print("Enter message for the server: ");
                String clientMessage = scanner.nextLine();
                dataOutputStream.writeUTF(clientMessage);
                dataOutputStream.flush();

                if (clientMessage.equals("exit")) {
                    System.out.println("Exit from the System..........");
                    break;
                }

                // Receive message from the server
                String serverMessage = dataInputStream.readUTF();
                System.out.println("Server: " + serverMessage);
            }

            // close the connection
            socket.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
