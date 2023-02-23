package Sockets;

import model.*;

import java.io.*;
import java.net.Socket;
import java.sql.SQLException;

public class ClientHandler implements Runnable {
    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;
    private ObjectOutputStream oOut;
    private ConvertSongToBytes convertFileToBytes;
    private MainModel model;
    private LoginModel loginModel;

    public ClientHandler(Socket socket, MainModel model, LoginModel loginModel) throws IOException {
        this.socket = socket;
        this.model = model;
        this.loginModel = loginModel;
        convertFileToBytes = new ConvertSongToBytes();
        in = new DataInputStream(socket.getInputStream());
        out = new DataOutputStream(socket.getOutputStream());
        oOut = new ObjectOutputStream(socket.getOutputStream());
    }


    @Override
    public void run() {
        try {
            String request = in.readUTF();
            System.out.println(1);
            System.out.println(request);
            switch (request) {
                case "songlist" -> {
                    try {
                        oOut.writeObject(model.getAllSongs());
                        System.out.println("Song list sent!");
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
                case "song" -> {
                    System.out.println("We finnaly get here");
                    int id = in.readInt();
                    byte[] file = convertFileToBytes.convert(model.getSong(id));
                    System.out.println(file.length);
                    out.writeInt(file.length);
                    System.out.println("we sent the length" + file.length);
                    out.write(file);
                    System.out.println("Byte array sent!");
                }
                case "login" -> {
                    System.out.println("Logging in...");
                    String usern = in.readUTF();
                    Username username = new Username(usern);
                    usern = in.readUTF();
                    Password password = new Password(usern);
                    boolean bol = loginModel.login(username, password);
                    System.out.println(bol);
                    oOut.writeObject(bol);
                    if(bol) {
                        int id = loginModel.getUserID(username, password);
                        oOut.writeObject(id);
                    }
                }
                case "register" -> {
                    System.out.println("Registering...");
                    String usern = in.readUTF();
                    System.out.println(2);
                    Username username = new Username(usern);
                    usern = in.readUTF();
                    System.out.println(3);
                    Email email = new Email(usern);
                    usern = in.readUTF();
                    System.out.println(4);
                    Password password = new Password(usern);
                    boolean bol = loginModel.register(username, email, password);
                    System.out.println(bol);
                    oOut.writeObject(bol);
                    int id = loginModel.getUserID(username,password);
                    oOut.writeObject(id);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        close();
    }


    public void close() {
        try {
            in.close();
            out.close();
            oOut.close();
            socket.close();
            Thread.currentThread().stop();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
