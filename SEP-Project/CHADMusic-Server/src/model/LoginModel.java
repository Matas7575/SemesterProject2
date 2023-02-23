package model;

/**
 * a interface that represents the login model
 * @author Matas Armonaitis, Dragos Bonaparte, Chiril Luncasu, Dan Sabastian
 * @version 1.0 - May 2022
 */
public interface LoginModel {
  /**
   * a boolean method that takes the arguments and checks them in the database
   * @param username the username being checked
   * @param password the password being checked
   * @return a boolean value signifying that the operation was a success or not
   */
  boolean login(Username username, Password password);
  /**
   * a boolean method that takes the arguments and checks them in the database and adds them in the database
   * @param username the username being checked
   * @param password the password being checked
   * @param email the email being checked
   * @return a boolean value signifying that the operation was a success or not
   */
  boolean register(Username username, Email email, Password password);

  /**
   * a method that searches using two parameters and gets the id of that user
   * @param username the username of the user
   * @param password the password of the user
   * @return the unique user id
   */
  int getUserID(Username username, Password password);
}
