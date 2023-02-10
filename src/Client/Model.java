package Client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Model {
    private Socket socket;
    private PrintWriter out;
    private BufferedReader in;
    private ListenerThread listenerThread;

    public Model(String ip, int port) {
        try {
            socket = new Socket(ip,port);
        } catch (IOException e) {
            System.err.println("Failed to connect to server");
            e.printStackTrace();
        }
        System.out.println("Connection ready...");
    }

    protected void getStreams() {
        try {
            out = new PrintWriter(socket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Streams ready...");
        listenerThread = new ListenerThread(in, System.out);
    }

    protected void runProtocol() {
        Scanner tgb = new Scanner(System.in);
        System.out.println("Chatting...");
        String msgLine = "";
        while (!msgLine.equals("QUIT")) {
            msgLine = "CLIENT: " + tgb.nextLine();
            out.println(msgLine);
        }
    }

    protected void shutDown() {
        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Socket getSocket() {
        return socket;
    }

    public PrintWriter getOut() {
        return out;
    }

    public BufferedReader getIn() {
        return in;
    }

    public ListenerThread getListenerThread() {
        return listenerThread;
    }
}
