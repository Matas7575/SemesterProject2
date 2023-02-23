package Sockets;

import model.MainModel;
import model.Password;
import model.Username;

import java.io.*;
import java.net.Socket;

public class ClientLogInHandler {
    private DataInputStream in;
    private DataOutputStream out;
    private ObjectInputStream oIn;
    private MainModel model;
    private Socket socket;
    private Username username;
    private Password password;

    public ClientLogInHandler(Socket socket, MainModel model, Username username, Password password) {
        this.socket = socket;
        this.username = username;
        this.password = password;
        this.model = model;
        try {
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());
            oIn = new ObjectInputStream(socket.getInputStream());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void login() {
        try {
            System.out.println("Connected");
            out.writeUTF("login");
            out.writeUTF(username.getName());
            out.writeUTF(password.getPass());
            boolean bol = (boolean) oIn.readObject();
            model.setLoggedIn(bol);
            if (bol) {
                model.setUserID((int) oIn.readObject());
                System.out.println("This user's id is: " + model.getUserID());
            }
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        close();
    }

    public void close() {
        try {
            in.close();
            out.close();
            socket.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
