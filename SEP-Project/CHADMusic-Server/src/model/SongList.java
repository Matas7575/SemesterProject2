package model;

import java.io.Serializable;
import java.util.ArrayList;
/*** a class that represents a Song list
 * @author Matas Armonaitis, Dragos Bonaparte, Chiril Luncasu, Dan Sabastian
 * @version 1.0 - May 2022
 */
public class SongList implements Serializable
{

  private ArrayList<Song> songs;

  /**
   * a constructor for SongList class
   */
  public SongList() {
    songs = new ArrayList<>();
  }

  /**
   * a method to add a song to "songs" arraylist
   * @param song variable that is added to the arraylist
   */
  public void addSong(Song song) {
    songs.add(song);
  }

  /**
   * a getter method to get all the songs from the "songs" arraylist
   * @return all songs from the array list
   */
  public ArrayList<Song> getAllSongs()
  {
    return songs;
  }

  /**
   * a getter for the size of the "songs" arraylist
   * @return size of the arraylist as an int
   */
  public int size() {
    return songs.size();
  }

  /**
   * a getter for a Song from the "songs" arraylist
   * @param index variable that lets to get a certain song from the arraylist
   * @return a song as Song type
   */
  public Song getSong(int index) {
    return songs.get(index);
  }

  public boolean isEmpty() {
    return songs.isEmpty();
  }
  /**
   * a getter for all instance variables of a class to a string
   * @return all instance variables to a string.
   */
  @Override
  public String toString() {
    return songs.toString();
  }

}
