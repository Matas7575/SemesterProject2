package model;

import java.io.Serializable;
import java.util.ArrayList;

/*** a class that represents playlists list
 * @author Matas Armonaitis, Dragos Bonaparte, Chiril Luncasu, Dan Sabastian
 * @version 1.0 - May 2022
 */
public class PlaylistList implements Serializable {
  private ArrayList<Playlist> playlists;

  /**
   * a Constructor for class PlaylistList
   */
  public PlaylistList() {
    this.playlists = new ArrayList<>();
    this.playlists.add(new LikedSongs());
  }

  /**
   * a method that adds a playlist to "playlists" arraylist
   * @param name a variable that represents the name of the playlist as a String
   */
  public void addPlaylist(String name) {
    playlists.add(new UserPlaylists(name));
  }

  /**
   * a method that removes a playlist from "playlists" arraylist
   * @param playlist playlist variable that user wants to remove as Playlist type
   */
  public void removePlaylist(Playlist playlist) {
    playlists.remove(playlist);
  }

  /**
   * a getter method for a playlist
   * @param index an index of a playlist that a user wants as an int
   * @return a playlist as a Playlist type
   */
  public Playlist getPlaylist(int index) {
    return playlists.get(index);
  }

  /**
   * a getter for all the playlists in the "playlists" arraylist
   * @return all playlists
   */
  public ArrayList<Playlist> getAllPlaylists() {
    return playlists;
  }

  /**
   * a getter for the size of the "playlists" arraylist
   * @return a size of the "playlists" arraylist as an int
   */
  public int playlistsSize()
  {
    return playlists.size();
  }
}
