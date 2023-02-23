package model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.sql.*;
import java.util.ArrayList;

/*** a class that manages the login
 * @author Matas Armonaitis, Dragos Bonaparte, Chiril Luncasu, Dan Sabastian
 * @version 1.0 - May 2022
 */
public class LoginModelManager implements LoginModel {
    /**
     * constructor for LoginModelManager class
     */
    public LoginModelManager() {
    }

    /**
     * a method that allows a user to log in and checks if the specific user already exists in the system
     *
     * @param username variable as Username type
     * @param password variable as Password type
     */
    @Override
    public boolean login(Username username, Password password) {
        try {
            DriverManager.registerDriver(new org.postgresql.Driver());
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "981230");
            PreparedStatement setSchema = connection.prepareStatement("set schema 'musicdata';");
            setSchema.executeUpdate();
            PreparedStatement numberOfUsers = connection.prepareStatement("SELECT count(*) FROM user_");
            ResultSet count = numberOfUsers.executeQuery();
            while (count.next()) {
                for (int i = 1; i <= Integer.parseInt(count.getString(1)); i++) {
                    PreparedStatement statement = connection.prepareStatement("SELECT count(*) FROM user_ WHERE username LIKE '" + username.getName() + "' AND password LIKE '" + password.getPass() + "';");
                    ResultSet set = statement.executeQuery();
                    if (set.next()) {
                        if (Integer.parseInt(set.getString(1)) == 1) {
                            connection.close();
                            return true;
                        }
                    } else
                        connection.close();
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }

    /**
     * a method that registers a new user to the system
     *
     * @param username variable as Username type
     * @param email    variable as Email type
     * @param password variable as Password type
     */
    @Override
    public boolean register(Username username, Email email, Password password) {
        try {
            DriverManager.registerDriver(new org.postgresql.Driver());
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "981230");
            PreparedStatement setSchema = connection.prepareStatement("set schema 'musicdata';");
            setSchema.executeUpdate();
            PreparedStatement numberOfUsers = connection.prepareStatement("SELECT count(*) FROM user_");
            ResultSet count = numberOfUsers.executeQuery();
            while (count.next()) {
                for (int i = 1; i <= Integer.parseInt(count.getString(1)); i++) {
                    PreparedStatement statement = connection.prepareStatement("SELECT count(*) FROM user_ WHERE username LIKE '" + username.getName() + "' AND password LIKE '" + password.getPass() + "' AND email like '" + email.getEmail() + "';");
                    ResultSet set = statement.executeQuery();
                    if (set.next()) {
                        if (set.getString(1).equalsIgnoreCase("0")) {
                            PreparedStatement registration = connection.prepareStatement("INSERT INTO user_(username, password, email, artist) VALUES(?,?,?,?);");
                            registration.setString(1, username.getName());
                            registration.setString(2, password.getPass());
                            registration.setString(3, email.getEmail());
                            registration.setBoolean(4, false);
                            registration.executeUpdate();
                            connection.close();
                            return true;
                        } else {
                            connection.close();
                            return false;
                        }
                    } else
                        connection.close();
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }

    /**
     * a method that gets the user's id such that it can be used for identifying it's name and it's specific liked song playlist
     * @param username the username of the user
     * @param password the password of the user
     * @return the id of the user having those credentials
     */
    @Override
    public int getUserID(Username username, Password password) {
        try {
            DriverManager.registerDriver(new org.postgresql.Driver());
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "981230");
            PreparedStatement setSchema = connection.prepareStatement("set schema 'musicdata';");
            setSchema.executeUpdate();
            PreparedStatement numberOfUsers = connection.prepareStatement("SELECT count(*) FROM user_");
            ResultSet count = numberOfUsers.executeQuery();
            while (count.next()) {
                for (int i = 1; i <= Integer.parseInt(count.getString(1)); i++) {
                    PreparedStatement statement = connection.prepareStatement("SELECT userid FROM user_ WHERE username LIKE '" + username.getName() + "' AND password LIKE '" + password.getPass() + "';");
                    ResultSet set = statement.executeQuery();
                    if (set.next()) {
                        int answer = set.getInt(1);
                        connection.close();
                        return answer;
                    } else
                        connection.close();
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return 0;
    }
}
