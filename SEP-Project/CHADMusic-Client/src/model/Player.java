package model;

import resources.MusicAPI.MP3;
/*** a class that represents a player of the program
 * @author Matas Armonaitis, Dragos Bonaparte, Chiril Luncasu, Dan Sabastian
 * @version 1.0 - May 2022
 */
public class Player{
  private MP3 mp3;

  /**\
   * a constructor for class Player
   */
  public Player() {
    mp3 = new MP3();
  }

  /**
   * a method to set a song to play
   * @param path a variable that gives the path of the song as a String
   */
  public void setPlaying(String path) {
    mp3.playSong(path);
  }

  /**
   * a method that skips the song
   */
  public void next() {
    mp3.next();
  }

  /**
   * a method that stops a song from playing
   */
  public void pausePlaying() {
    mp3.pauseSong();
  }

  /**
   * a getter for MP3 variable
   * @return mp3 variable as MP3 type
   */
  public MP3 getMp3() {
    return mp3;
  }
}
