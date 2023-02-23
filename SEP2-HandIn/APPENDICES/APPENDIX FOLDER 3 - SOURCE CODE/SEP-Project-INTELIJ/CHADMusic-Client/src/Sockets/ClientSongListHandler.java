package Sockets;

import model.MainModel;
import model.SongList;
import java.io.*;
import java.net.Socket;

public class ClientSongListHandler implements Runnable{
    private DataInputStream in;
    private DataOutputStream out;
    private ObjectInputStream oIn;
    private MainModel model;
    private Socket socket;

    public ClientSongListHandler(Socket socket, MainModel model) {
        try {
            this.socket = socket;
            this.model = model;
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());
            oIn = new ObjectInputStream(socket.getInputStream());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void run() {
        try {
            out.writeUTF("songlist");
            SongList songList = (SongList) oIn.readObject();
            model.setSongList(songList);
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }finally{
            close();
        }
    }

    public void close() {
        try {
            in.close();
            out.close();
            oIn.close();
            socket.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
