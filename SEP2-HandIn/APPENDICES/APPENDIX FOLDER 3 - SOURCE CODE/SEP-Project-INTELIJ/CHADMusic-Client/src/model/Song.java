package model;

import java.io.Serializable;
/*** a class that represents a Song
 * @author Matas Armonaitis, Dragos Bonaparte, Chiril Luncasu, Dan Sabastian
 * @version 1.0 - May 2022
 */
public class Song implements Serializable {
  private int id;
  private String name;
  private Artist artist;
  private String length;
  private String path;
  /**
   * a constructor for Song class
   * @param id instance variable as an int
   * @param name instance variable as a String
   * @param artist instance variable as an Artist type
   * @param length instance variable as a String
   * @param path instance variable as a String
   */
  public Song(int id,String name, Artist artist, String length, String path) {
    this.id = id;
    this.name = name;
    this.artist = artist;
    this.length = length;
    this.path = path;
  }
  /**
   * a getter for the id instance variable
   * @return id as an int
   */
  public int getId() {
    return id;
  }
  /**
   * a getter for name instance variable
   * @return a name as a String
   */
  public String getName() {
    return name;
  }
  /**
   * a getter for Artist instance variable
   * @return an artist as an Artist type
   */
  public Artist getArtist() {
    return artist;
  }
  /**
   * a getter for length instance variable
   * @return length as a String
   */
  public String getLength() {
    return length;
  }
  /**
   * a getter for path instance variable
   * @return path as a String
   */
  public String getPath() {
    return path;
  }
  /**
   * a getter for all instance variables of a class to a string
   * @return all instance variables to a string.
   */
  @Override
  public String toString() {
    return name + " " + artist.getAName();
  }
}
