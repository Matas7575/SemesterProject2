package model;
/*** a class that represents a solo artist
 * @author Matas Armonaitis, Dragos Bonaparte, Chiril Luncasu, Dan Sabastian
 * @version 1.0 - May 2022
 */
public class Solo implements Artist {

  private User user;
  private String aName;
  /**
   * a constructor for class Solo
   * @param user initialises user instance variable as a User type
   * @param aName initialises aName instance variable as a String
   */
  public Solo(User user, String aName) {
    this.user = user;
    this.aName = aName;
  }
  /**
   * a getter for aName
   * @return a aName instance variable as a String
   */
  @Override public String getAName() {
    return aName;
  }
  /**
   * a getter for userId
   * @return a userId as an int
   */
  @Override public int getUserId() {
    return user.getUserId();
  }
  /**
   * a getter for username
   * @return a username as a Username type
   */
  @Override public Username getUsername() {
    return user.getUsername();
  }
  /**
   * a getter for email
   * @return an email as an Email type
   */
  @Override public Email getEmail() {
    return user.getEmail();
  }
  /**
   * a getter for password
   * @return a password as a Password type
   */
  @Override public Password getPassword() {
    return user.getPassword();
  }
}
