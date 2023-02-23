package model;

import java.util.ArrayList;
/*** a class that represents a users liked songs
 * @author Matas Armonaitis, Dragos Bonaparte, Chiril Luncasu, Dan Sabastian
 * @version 1.0 - May 2022
 */
public class LikedSongs implements Playlist {

  private ArrayList<Song> songs;

  /**
   * a constructor for LikedSongs class
   */
  public LikedSongs() {
    songs = new ArrayList<>();
  }

  /**
   * a method to add a song to "songs" arraylist
   * @param song a song variable as Song type
   */
  @Override public void addSong(Song song) {
    songs.add(song);
  }

  /**
   * a method to remove a song from "songs" arraylist
   * @param song a song variable as Song type
   */
  @Override public void removeSong(Song song) {
    songs.remove(song);
  }

  /**
   * a getter for a song from an arraylist "songs"
   * @param index an index of the song from the arraylist as an int
   * @return a certain song from an arraylist as Song type
   */
  @Override
  public Song getSong(int index) {
    return songs.get(index);
  }

  /**
   * a method to get all the songs from the "songs" arraylist
   * @return all the songs from the arraylist
   */
  @Override
  public ArrayList<Song> getAllSongs() {
    return songs;
  }

  /**
   * a getter for all instance variables of a class to a string
   * @return all instance variables to a string.
   */
  @Override
  public String toString() {
    return "LikedSongs{" +
            "songs=" + songs +
            ", totalLength=" +
            '}';
  }
}
