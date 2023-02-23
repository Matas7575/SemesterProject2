package Sockets;

import model.ConvertSongToBytes;
import model.LoginModel;
import model.MainModel;
import model.Song;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server implements Runnable {
    private ServerSocket welcomeSocket;
    private MainModel model;
    private LoginModel loginModel;
    private boolean running;

    public Server(int port, MainModel model, LoginModel loginModel) throws IOException {
        this.model = model;
        welcomeSocket = new ServerSocket(port);
        this.loginModel = loginModel;
    }


    @Override
    public void run() {
        try {
            running = true;
            while (running) {
                System.out.println("Server started");
                System.out.println("Waiting for client...");
                Socket socket = welcomeSocket.accept();
                System.out.println("Client accepted");
                ClientHandler clientHandler = new ClientHandler(socket,
                        model, loginModel);
                Thread clientThread = new Thread(clientHandler);
                clientThread.setDaemon(true);
                clientThread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void close() {
        running = false;
        try {
            welcomeSocket.close();
        } catch (Exception e) {
            //
        }
    }
}

