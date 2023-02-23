package model;

import java.io.Serializable;
/*** a class that represents a users email
 * @author Matas Armonaitis, Dragos Bonaparte, Chiril Luncasu, Dan Sabastian
 * @version 1.0 - May 2022
 */
public class Email implements Serializable {
    private String email;
    /**
     * A constructor for Email class
     * @param email initialises an email instance variable as a String
     */
    public Email(String email) {
        this.email = email;
    }

    /**
     * a getter for email
     * @return an email instance variable as a String
     */
    public String getEmail() {
        return email;
    }
    /**
     * a setter for email
     * @param email sets email instance variable to a different email as a String
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * a getter for all instance variables of a class to a string
     * @return all instance variables to a string.
     */
    @Override
    public String toString() {
        return "Email{" +
                "email='" + email;
    }
}
