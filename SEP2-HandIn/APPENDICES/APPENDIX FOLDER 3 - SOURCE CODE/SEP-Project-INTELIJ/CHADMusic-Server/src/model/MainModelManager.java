package model;

import Sockets.Server;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.IOException;
import java.sql.*;
/*** a class that manages the main window of the program
 * @author Matas Armonaitis, Dragos Bonaparte, Chiril Luncasu, Dan Sabastian
 * @version 1.0 - May 2022
 */
public class MainModelManager implements MainModel {

    private SongList songList;
    private LoginModel loginModel;
    private Thread serverThread;
    private PropertyChangeSupport property;

    private Server server;
    /**
     * a constructor for class MainModelManager
     */
    public MainModelManager() {
        property = new PropertyChangeSupport(this);
        songList = new SongList();
        loginModel = new LoginModelManager();
        try {
            songList = loadAllSongsFromDatabase();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            server = new Server(6000, this, loginModel);
            serverThread = new Thread(server);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        serverThread.start();
    }

    /**
     * a method to get all the songs from SongList
     * @return SongList type variable
     */
    @Override
    public SongList getAllSongs() {
        return songList;
    }

    /**
     * a method that gets a song by its id
     * @param id variable as an int
     * @return a song from songList as Song type
     */
    @Override
    public Song getSong(int id) {
        return songList.getSong(id - 1);
    }

    /**
     * a method that loads all of the songs from the database
     * @return songList variable as SongList type
     * @throws SQLException
     */
    @Override
    public SongList loadAllSongsFromDatabase() throws SQLException {
        DriverManager.registerDriver(new org.postgresql.Driver());
        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "981230");
        PreparedStatement setSchema = connection.prepareStatement("set schema 'musicdata';");
        setSchema.executeUpdate();
        try {
            PreparedStatement numberOfSongs = connection.prepareStatement("SELECT count(*) FROM song");
            ResultSet count = numberOfSongs.executeQuery();
            while (count.next()) {
                for (int i = 1; i <= Integer.parseInt(count.getString(1)); i++) {
                    PreparedStatement statement = connection.prepareStatement("SELECT * FROM song WHERE songid=" + i + ";");
                    ResultSet set = statement.executeQuery();
                    while (set.next()) {
                        Solo artist = new Solo(new User(1, new Username("Michael Jackson"), new Email("michaeljackson"), new Password("password")), set.getString(3));
                        String path = set.getString(5);
                        System.out.println(path);
                        Song song = new Song(set.getInt(1), set.getString(2), artist, set.getString(4), set.getString(5));
                        songList.addSong(song);
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            connection.close();
        }
        return songList;
    }
    /**
     * method that adds a listener
     * @param propertyName event name
     * @param listener listener to be added
     */
    @Override
    public void addListener(String propertyName, PropertyChangeListener listener) {
        property.addPropertyChangeListener(propertyName, listener);
    }
    /**
     * method that removes a listener
     * @param propertyName event name
     * @param listener listener to be removed
     */
    @Override
    public void removeListener(String propertyName, PropertyChangeListener listener) {
        property.removePropertyChangeListener(propertyName, listener);
    }
}
