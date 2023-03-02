package Server;

import Client.ListenerThread;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Model {
    private ServerSocket server;
    private Socket client;
    private PrintWriter out;
    private BufferedReader in;
    private ListenerThread listenerThread;

    public Model(int port) {
        try {
            server = new ServerSocket(port);
        } catch (IOException e) {
            System.err.println("Failed to open serversocket.");
            e.printStackTrace();
        }
        System.out.println("Server started...");
    }

    public void acceptClient() {
        try {
            client = server.accept();
        } catch (IOException e) {
            System.err.println("Failed to connect to client");
            e.printStackTrace();
        }
        System.out.println("client connected...");
    }

    public void getStreams() {
        try {
            out = new PrintWriter(client.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(client.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Streams ready...");
        listenerThread = new ListenerThread(in, System.out);
    }

    public String runProtocol() {
        Scanner tgb = new Scanner(System.in);
        System.out.println("chatting...");
        String msg = "";
        while (!msg.equals("QUIT")) {
            msg = "SERVER: " + tgb.nextLine();
            return msg;
        }
        return "SERVER quit...";
    }

    public void shutdown() {
        try {
            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ListenerThread getListenerThread() {
        return listenerThread;
    }
}