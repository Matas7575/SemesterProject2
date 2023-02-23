package model;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BandTest {
    private Username username = new Username("someDude");
    private Password password = new Password("password");
    private Email email = new Email("email");
    private User user = new User(1234, username, email, password);

    @Test
    void contructor_Z() {
        //not relevant
    }

    @Test
    void constructor_O() {
        assertDoesNotThrow(() -> new Band(user, "ugandon"));
    }

    @Test
    void constructor_M() {
        //not relevant
    }

    @Test
    void constructor_B() {
        //not relevant
    }

    @Test
    void constructor_E() {
        //not relevant
    }

    @Test
    void getAName_Z() {
        Band band = new Band(null, null);
        assertEquals(null, band.getAName());
    }

    @Test
    void getAName_O() {
        Band band = new Band(user, "someone");
        assertEquals("someone", band.getAName());
    }

    @Test
    void getAName_M() {
        //not relevant
    }

    @Test
    void getAName_B() {
        //not relevant
    }

    @Test
    void getAName_E() {
        //not relevant
    }

    @Test
    void getUserId_Z() {
        Band band = new Band(null, null);
        assertThrows(NullPointerException.class, band::getUserId);
    }

    @Test
    void getUserId_O() {
        Band band = new Band(user, "someone");
        assertEquals(1234, band.getUserId());
    }

    @Test
    void getUserId_M() {
        //not relevant
    }

    @Test
    void getUserId_B() {
        //not relevant
    }

    @Test
    void getUserId_E() {
        //not relevant
    }

    @Test
    void getUsername_Z() {
        Band band = new Band(null, null);
        assertThrows(NullPointerException.class, band::getUsername);
    }

    @Test
    void getUsername_O() {
        Band band = new Band(user, "someone");
        assertEquals("someDude", band.getUsername().getName());
    }

    @Test
    void getUsername_M() {
        //not relevant
    }

    @Test
    void getUsername_B() {
        //not relevant
    }

    @Test
    void getUsername_E() {
        //not relevant
    }

    @Test
    void getEmail_Z() {
        Band band = new Band(null, null);
        assertThrows(NullPointerException.class, band::getEmail);
    }

    @Test
    void getEmail_O() {
        Band band = new Band(user, "someone");
        assertEquals("email", band.getEmail().getEmail());
    }

    @Test
    void getEmail_M() {
        //not relevant
    }
    @Test
    void getEmail_B() {
        //not relevant
    }
    @Test
    void getEmail_E() {
        //not relevant
    }

    @Test
    void getPassword_Z() {
        Band band = new Band(null, null);
        assertThrows(NullPointerException.class, band::getPassword);
    }

    @Test
    void getPassword_O() {
        Band band = new Band(user, "someone");
        assertEquals("password", band.getPassword().getPass());
    }
    @Test
    void getPassword_M() {
        //not relevant
    }
    @Test
    void getPassword_B() {
        //not relevant
    }
    @Test
    void getPassword_E() {
        //not relevant
    }
}