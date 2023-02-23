package Sockets;

import model.ConvertBytesToFile;
import model.MainModel;

import java.io.*;
import java.net.Socket;

public class ClientSongRequestHandler {
    private DataInputStream in;
    private DataOutputStream out;
    private byte[] fileReceived;
    private ConvertBytesToFile convert;
    private MainModel model;
    private Socket socket;
    private int id;
    private ByteArrayOutputStream baos;

    public ClientSongRequestHandler(Socket socket, MainModel model, int id) {
        try {
            this.socket = socket;
            this.model = model;
            this.id = id;
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());
            baos = new ByteArrayOutputStream();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void getSong() {
        try {
            out.writeUTF("song");
            out.writeInt(id);
            int length = in.readInt();
            length = in.readInt();
            System.out.println(length);
            fileReceived = new byte[length];
            in.readFully(fileReceived,0, fileReceived.length);
            ConvertBytesToFile.writeByte(fileReceived);
            System.out.println("Byte array successfully received");
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            close();
        }
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
