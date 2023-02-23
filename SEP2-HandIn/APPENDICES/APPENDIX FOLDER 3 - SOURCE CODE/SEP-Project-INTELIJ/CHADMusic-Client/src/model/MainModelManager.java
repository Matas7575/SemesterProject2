package model;

import Sockets.Client;
import resources.MusicAPI.MP3;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.IOException;

/*** a class that manages the main window of the program
 * @author Matas Armonaitis, Dragos Bonaparte, Chiril Luncasu, Dan Sabastian
 * @version 1.0 - May 2022
 */
public class MainModelManager implements MainModel {

    private Player player;
    private LikedSongs likedSongs;
    private SongList songList;
    private boolean isLoggedIn, playing, repeat;
    private Lyrics lyrics;
    private Song song;
    private PropertyChangeSupport property;
    private Client client;
    private int playingId, userID;

    /**
     * a constructor for class MainModelManager
     */
    public MainModelManager() {
        property = new PropertyChangeSupport(this);
        lyrics = new Lyrics();
        likedSongs = new LikedSongs();
        playing = false;
        player = new Player();
        songList = new SongList();
        client = new Client("localhost", 6000, this);
        repeat = false;
    }

    /**
     * a getter for the id of the client user
     * @return userID as an int
     */
    public int getUserID() {
        return userID;
    }

    /**
     * a method that adds a song to the LikedSongs arraylist
     * @param currentlyPlaying gives the song to be added
     */
    @Override
    public void addToLikedSongs(Song currentlyPlaying) {
        likedSongs.addSong(currentlyPlaying);
    }

    /**
     * a method that sets the id of an user
     * @param userID the id that is set to
     */
    public void setUserID(int userID) {
        this.userID = userID;
    }

    /**
     * a method that asks the client to log in the server
     * @param username the username of the user
     * @param password the password of the user
     */
    @Override
    public void logIn(Username username, Password password) {
        client.logIn(username,password);
    }

    /**
     * a methods that asks the client to register the user in the server
     * @param username the username of the user
     * @param email the email of the user
     * @param password the password of the user
     */
    @Override
    public void register(Username username, Email email, Password password) {
        client.register(username,email,password);
    }

    /**
     * a getter method to get the currently playing song
     *
     * @return a song as Song type
     */
    @Override
    public Song getCurrentlyPlaying() {
        return song;
    }

    /**
     * a getter method for the currently playing songs id
     *
     * @return playingId as an int
     */
    @Override
    public int getPlayingId() {
        return playingId;
    }

    /**
     * a method that sets a certain song to play
     *
     * @param song variable as Song type
     */
    public void setCurrentlyPlaying(Song song) {
        System.out.println(song);
        player.pausePlaying();
        playingId = song.getId();
        this.song = song;
        client.getSong(playingId);
        player.setPlaying(ConvertBytesToFile.sendPath());
        player.next();
    }

    /**
     * a method the returns if the user is logged in or not in a boolean value
     * @return a boolean
     */
    public boolean isLoggedIn() {
        return isLoggedIn;
    }

    /**
     * a setter for the boolean variable loggedIn
     * @param loggedIn the boolean value to be set to
     */
    public void setLoggedIn(boolean loggedIn) {
        isLoggedIn = loggedIn;
    }

    /**
     * a getter method for lyrics
     *
     * @param songName variable as a String
     */
    @Override
    public void getLyrics(String songName) {
        try {
            property.firePropertyChange("lyrics", " ", lyrics.getLyrics(songName));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * a getter for the MP3
     *
     * @return mp3 as MP3 type
     */
    @Override
    public MP3 getMP3() {
        return player.getMp3();
    }

    /**
     * a method that sets a song list to a new song list
     *
     * @param songList new song list variable as SongList type
     */
    @Override
    public void setSongList(SongList songList) {
        this.songList = songList;
        property.firePropertyChange("songList", null, songList);
    }

    /**
     * a method that sets the player to either play the song or pause it
     */
    @Override
    public synchronized void togglePlayPause() {
        if (playing) {
            player.pausePlaying();
            playing = false;
        } else {
            player.setPlaying(ConvertBytesToFile.sendPath());
            playing = true;
            Thread mp3 = new Thread(player.getMp3());
            mp3.setDaemon(true);
            mp3.setPriority(10);
            mp3.start();
        }
    }

    /**
     * a method that sets the song to repeat
     */
    public void setRepeat() {
        repeat = !repeat;
    }

    /**
     * a method that shows weather the song is repeating or no
     *
     * @return a boolean type variable
     */
    public boolean getRepeat() {
        return repeat;
    }

    /**
     * a method to get all the songs from SongList
     *
     * @return SongList type variable
     */
    @Override
    public SongList getAllSongs() {
        if (songList.isEmpty())
            client.getSongList();
        return songList;
    }

    /**
     * a method that shows if the song is currently playing
     *
     * @return boolean type variable
     */
    @Override
    public boolean getPlaying() {
        return playing;
    }

    /**
     * method that adds a listener
     *
     * @param propertyName event name
     * @param listener     listener to be added
     */
    @Override
    public void addListener(String propertyName, PropertyChangeListener listener) {
        property.addPropertyChangeListener(propertyName, listener);
    }

    /**
     * method that removes a listener
     *
     * @param propertyName event name
     * @param listener     listener to be removed
     */
    @Override
    public void removeListener(String propertyName, PropertyChangeListener listener) {
        property.removePropertyChangeListener(propertyName, listener);
    }
}
