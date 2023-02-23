package model;

import utility.observer.javaobserver.NamedPropertyChangeSubject;
import java.sql.SQLException;
/**
 * a interface that represents the main model
 * @author Matas Armonaitis, Dragos Bonaparte, Chiril Luncasu, Dan Sabastian
 * @version 1.0 - May 2022
 */
public interface MainModel extends NamedPropertyChangeSubject {
  /**
   * a method that gets all the songs from the database
   * @return the songlist of songs
   */
  SongList getAllSongs();

  /**
   * a method that gets a song based on the id
   * @param id is the index were the song is in the database
   * @return the song
   */
  Song getSong(int id);

  /**
   * a method that loads all the songs from the database
   * @return a songlist object containg everything
   * @throws SQLException if the connection cannot be established
   */
  SongList loadAllSongsFromDatabase() throws SQLException;
}
