package model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * a interface that represents the playlist
 * @author Matas Armonaitis, Dragos Bonaparte, Chiril Luncasu, Dan Sabastian
 * @version 1.0 - May 2022
 */
public interface Playlist extends Serializable {
  /**
   * a adder for the song
   * @param song the song that's being added
   */
  void addSong(Song song);

  /**
   * a remove method for the playlist
   * @param song the song being removed
   */
  void removeSong(Song song);

  /**
   * a getter for the song based on the index
   * @param index the index where the song is
   * @return the song
   */
  Song getSong(int index);

  /**
   * a method that returns all the songs from that playlist
   * @return all the songs
   */
  ArrayList<Song> getAllSongs();
}
