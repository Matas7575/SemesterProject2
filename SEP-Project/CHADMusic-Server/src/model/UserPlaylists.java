package model;

import java.util.ArrayList;
/*** a class that represents users playlists
 * @author Matas Armonaitis, Dragos Bonaparte, Chiril Luncasu, Dan Sabastian
 * @version 1.0 - May 2022
 */
public class UserPlaylists implements Playlist {

  private String name;

  private ArrayList<Song> songs;
  private int totalLength;

  /**
   * constructor for UserPlaylists class
   * @param name instance variable as a String
   */
  public UserPlaylists(String name) {
    this.name = name;
    this.songs = new ArrayList<>();
  }

  /**
   * a method that adds a song to "songs" arraylist
   * @param song variable as Song type
   */
  @Override
  public void addSong(Song song) {
    songs.add(song);
  }

  /**
   * a metehod that removes a song from "songs" arraylist
   * @param song variable as Song type
   */
  @Override
  public void removeSong(Song song) {
    songs.remove(song);
  }

  /**
   * a getter for a specific song from "songs" arraylist
   * @param index a variable that allows user to pick a specific item from the "songs" arraylist
   * @return a song as Song type
   */
  @Override
  public Song getSong(int index) {
    return songs.get(index);
  }

  /**
   * a getter for all the songs from the "songs" arraylist
   * @return all songs from the array list
   */
  @Override
  public ArrayList<Song> getAllSongs() {
    return songs;
  }

  /**
   * a getter for name instance variable
   * @return a name as a String
   */
  public String getName() {
    return name;
  }
  /**
   * a getter for all instance variables of a class to a string
   * @return all instance variables to a string.
   */
  @Override
  public String toString() {
    return "UserPlaylists{" +
            "name='" + name + '\'' +
            ", songs=" + songs +
            ", totalLength=" + totalLength +
            '}';
  }
}
