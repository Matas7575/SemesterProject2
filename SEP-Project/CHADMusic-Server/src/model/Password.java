package model;

import java.io.Serializable;
/*** a class that represents a users password
 * @author Matas Armonaitis, Dragos Bonaparte, Chiril Luncasu, Dan Sabastian
 * @version 1.0 - May 2022
 */
public class Password implements Serializable {
    private String pass;
    /**
     * a constructor for the class Password
     * @param pass a pass instance variable as a String
     */
    public Password(String pass) {
        this.pass = pass;
    }
    /**
     * a getter for pass instance variable
     * @return pass variable as A String
     */
    public String getPass() {
        return pass;
    }
    /**
     * a setter for instance variable pass
     * @param pass a pass variable that is going to replace the instance variable pass as a String
     */
    public void setPass(String pass) {
        this.pass = pass;
    }
    /**
     * a getter for all instance variables of a class to a string
     * @return all instance variables to a string.
     */
    @Override
    public String toString() {
        return "Password{" +
                "pass='" + pass + '\'' +
                '}';
    }
}
