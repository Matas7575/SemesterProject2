package Sockets;

import model.*;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
    private Socket socket;

    private String adress;
    private int port;
    private ClientSongListHandler clientSongListHandler;
    private ClientSongRequestHandler clientSongRequestHandler;
    private ClientLogInHandler clientLogInHandler;
    private ClientRegisterHandler clientRegisterHandler;
    private MainModel model;

    public Client(String adress, int port, MainModel model) {
        this.model = model;
        this.adress = adress;
        this.port = port;
    }

    public void getSongList() {
        try{
            socket = new Socket(adress,port);
            if(socket.isConnected())
            {
                System.out.println("Connected");
                clientSongListHandler = new ClientSongListHandler(socket, model);
                Thread client = new Thread(clientSongListHandler);
                client.setDaemon(true);
                client.start();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void getSong(int id) {
        try{
            socket = new Socket(adress,port);
            if(socket.isConnected())
            {
                System.out.println("Connected");
                clientSongRequestHandler = new ClientSongRequestHandler(socket, model, id);
                clientSongRequestHandler.getSong();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void logIn(Username username,Password password) {
        try{
            socket = new Socket(adress,port);
            if(socket.isConnected()) {
                System.out.println("Connected");
                clientLogInHandler = new ClientLogInHandler(socket,model, username,password);
                clientLogInHandler.login();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void register(Username username,Email email,Password password) {
        try{
            socket = new Socket(adress,port);
            if(socket.isConnected()) {
                System.out.println("Connected");
                clientRegisterHandler = new ClientRegisterHandler(socket,model, username,email,password);
                clientRegisterHandler.register();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void close() {
        try {
            socket.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
