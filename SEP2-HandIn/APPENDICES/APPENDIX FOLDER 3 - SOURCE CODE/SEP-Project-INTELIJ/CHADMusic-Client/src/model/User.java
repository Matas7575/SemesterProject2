package model;
/*** a class that represents a User
 * @author Matas Armonaitis, Dragos Bonaparte, Chiril Luncasu, Dan Sabastian
 * @version 1.0 - May 2022
 */
public class User implements UserModel {

  private int userID;
  private Username username;
  private Email email;
  private Password password;
  PlaylistList playlistList;
  /**
   * a constructor for class User
   * @param userID instance variable as an int
   * @param username instance variable as Username type
   * @param email instance variable as Email type
   * @param password instance variable as Password type
   */
  public User(int userID, Username username, Email email, Password password) {
    this.userID = userID;
    this.username = username;
    this.email = email;
    this.password = password;
    this.playlistList = new PlaylistList();
  }
  /**
   * a getter for userId
   * @return userId as an int
   */
  @Override public int getUserId() {
    return userID;
  }
  /**
   * a getter for username
   * @return a username as a Username type
   */
  @Override public Username getUsername() {
    return username;
  }
  /**
   * a getter for email
   * @return an email as an Email type
   */
  @Override public Email getEmail() {
    return email;
  }
  /**
   * a getter for password
   * @return a password as a Password type
   */
  @Override public Password getPassword() {
    return password;
  }
  /**
   * a getter for liked songs playlist
   * @return playlist as Playlist type
   */
  public Playlist getLikedSongsPlaylist() {
    return playlistList.getPlaylist(0);
  }
  /**
   * a getter for playlist
   * @param index variable that allows user to get a certain playlist
   * @return a playlist as Playlist type
   */
  public Playlist getPlaylist(int index) {
    return playlistList.getPlaylist(index);
  }
  /**
   * a method that creates a playlist inside PlaylistList class arraylist
   * @param name name of the playlist as a String
   */
  public void createPlaylist(String name) {
    playlistList.addPlaylist(name);
  }
  /**
   * a method that removes a playlist from PlaylistList class arraylist
   * @param playlist variable as a Playlist type
   */
  public void removePlaylist(Playlist playlist) {
    playlistList.removePlaylist(playlist);
  }
}
