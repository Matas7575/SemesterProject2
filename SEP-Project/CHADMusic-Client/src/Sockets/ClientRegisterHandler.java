package Sockets;

import model.Email;
import model.MainModel;
import model.Password;
import model.Username;

import java.io.*;
import java.net.Socket;

public class ClientRegisterHandler{
    private DataInputStream in;
    private DataOutputStream out;
    private ObjectInputStream oIn;
    private MainModel model;
    private Socket socket;
    private Username username;
    private Password password;
    private Email email;

    public ClientRegisterHandler(Socket socket, MainModel model, Username username, Email email, Password password) {
        try {
            this.socket = socket;
            this.model = model;
            this.username = username;
            this.email = email;
            this.password = password;
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());
            oIn = new ObjectInputStream(socket.getInputStream());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void register() {
        try {
            System.out.println("We get to register socket");
            out.writeUTF("register");
            out.writeUTF(username.getName());
            out.writeUTF(email.getEmail());
            out.writeUTF(password.getPass());
            boolean bol = (boolean) oIn.readObject();
            model.setLoggedIn(bol);
            model.setUserID((int) oIn.readObject());
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
