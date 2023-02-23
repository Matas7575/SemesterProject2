package model;

import java.io.Serializable;

/***
 * a interface that represents the user model
 * @author Matas Armonaitis, Dragos Bonaparte, Chiril Luncasu, Dan Sabastian
 * @version 1.0 - May 2022
 */
public interface UserModel extends Serializable {
  /**
   * a getter for the user id
   * @return the user id
   */
  int getUserId();

  /**
   * a getter for the username
   * @return the username
   */
  Username getUsername();

  /**
   * a getter fot the email
   * @return the email
   */
  Email getEmail();

  /**
   * a getter for the password
   * @return the password
   */
  Password getPassword();
}
