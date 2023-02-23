package model;

import java.io.Serializable;

/***a interface that represents all the artist types
 * @author Matas Armonaitis, Dragos Bonaparte, Chiril Luncasu, Dan Sabastian
 * @version 1.0 - May 2022
 */
public interface Artist extends UserModel {
  /**
   * a getter for the name of the artist
   * @return a string signifying the name of the artist
   */
  String getAName();
}
