package model;

/*** a class that represents bands
 * @author Matas Armonaitis, Dragos Bonaparte, Chiril Luncasu, Dan Sabastian
 * @version 1.0 - May 2022
 */
public class Band implements Artist {


  private String aName;
  private User user;

  /**
   *A constructor for the Band class
   * @param user initialises User instance variable as a User
   * @param aName initialises aName instance variable as a String
   */
  public Band(User user, String aName) {
    this.user = user;
    this.aName = aName;
  }

  /**
   * a getter for aName
   * @return aName instance variable as a String
   */
  @Override public String getAName() {
    return aName;
  }

  /**
   * a getter for userId
   * @return userId as an int
   */
  @Override public int getUserId() {
    return user.getUserId();
  }

  /**
   * a getter for Username
   * @return a username variable as a Username
    */
  @Override public Username getUsername() {
    return user.getUsername();
  }

  /**
   * a getter for email
   * @return an email variable as an Email
   */
  @Override public Email getEmail() {
    return user.getEmail();
  }

  /**
   * a getter for password
   * @return a password variable as Password
   */
  @Override public Password getPassword() {
    return user.getPassword();
  }
}
