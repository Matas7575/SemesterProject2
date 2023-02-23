package model;

import resources.MusicAPI.MP3;
import utility.observer.javaobserver.NamedPropertyChangeSubject;

import java.sql.SQLException;
import java.util.ArrayList;

public interface MainModel extends NamedPropertyChangeSubject {
  Song getCurrentlyPlaying();
  void setCurrentlyPlaying(Song song);
  void getLyrics(String songName);
  void togglePlayPause();
  void setLoggedIn(boolean loggedIn);
  boolean isLoggedIn();
  int getPlayingId();
  SongList getAllSongs();
  void logIn(Username username, Password password);
  void register(Username username, Email email, Password password);
  void setRepeat();
  MP3 getMP3();
  boolean getRepeat();
  boolean getPlaying();
  void setSongList(SongList songList);
  void setUserID(int userID);
  int getUserID();

  void addToLikedSongs(Song currentlyPlaying);
}
