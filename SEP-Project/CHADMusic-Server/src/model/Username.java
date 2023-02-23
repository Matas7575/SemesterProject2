package model;

import java.io.Serializable;
/*** a class that represents a Username
 * @author Matas Armonaitis, Dragos Bonaparte, Chiril Luncasu, Dan Sabastian
 * @version 1.0 - May 2022
 */
public class Username implements Serializable {
    private String name;
    /**
     * a constructor for Username class
     * @param name instance variable as a String
     */
    public Username(String name) {
        this.name = name;
    }
    /**
     * a setter for name instance variable
     * @param name instance variable that is going to be instead of the original as a String
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * a getter for name instance variable
     * @return name instance variable as a String
     */
    public String getName() {
        return name;
    }
    /**
     * a getter for all instance variables of a class to a string
     * @return all instance variables to a string.
     */
    @Override
    public String toString() {
        return "Username{" +
                "name='" + name + '\'' +
                '}';
    }
}
