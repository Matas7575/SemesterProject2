package model;

import resources.LyricsAPI.genius.core.GLA;

import java.io.IOException;
/*** a class that represents a songs lyrics
 * @author Matas Armonaitis, Dragos Bonaparte, Chiril Luncasu, Dan Sabastian
 * @version 1.0 - May 2022
 */
public class Lyrics {
  private GLA gla;

  /**
   * a constructor for class Lyrics
   */
  public Lyrics() {
    gla = new GLA();
  }

  /**
   * a getter for lyrics
   * @param songName a song name as a String
   * @return lyrics for a certain song as a String
   * @throws IOException
   */
  public String getLyrics(String songName) throws IOException {
    try {
      return String.valueOf(gla.search(songName).getHits().get(0).fetchLyrics());
    }catch(Exception e) {
        return "Couldn't fetch lyrics";
    }
  }
}