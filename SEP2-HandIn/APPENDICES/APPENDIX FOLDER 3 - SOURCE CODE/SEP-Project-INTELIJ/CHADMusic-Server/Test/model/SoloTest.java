package model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
//This class is already tested in band(it is basically the same)
class SoloTest {
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
        assertDoesNotThrow(() -> new Solo(user, "ugandon"));
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
        Solo Solo = new Solo(null, null);
        assertEquals(null, Solo.getAName());
    }

    @Test
    void getAName_O() {
        Solo Solo = new Solo(user, "someone");
        assertEquals("someone", Solo.getAName());
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
        Solo Solo = new Solo(null, null);
        assertThrows(NullPointerException.class, Solo::getUserId);
    }

    @Test
    void getUserId_O() {
        Solo Solo = new Solo(user, "someone");
        assertEquals(1234, Solo.getUserId());
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
        Solo Solo = new Solo(null, null);
        assertThrows(NullPointerException.class, Solo::getUsername);
    }

    @Test
    void getUsername_O() {
        Solo Solo = new Solo(user, "someone");
        assertEquals("someDude", Solo.getUsername().getName());
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
        Solo Solo = new Solo(null, null);
        assertThrows(NullPointerException.class, Solo::getEmail);
    }

    @Test
    void getEmail_O() {
        Solo Solo = new Solo(user, "someone");
        assertEquals("email", Solo.getEmail().getEmail());
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
        Solo Solo = new Solo(null, null);
        assertThrows(NullPointerException.class, Solo::getPassword);
    }

    @Test
    void getPassword_O() {
        Solo Solo = new Solo(user, "someone");
        assertEquals("password", Solo.getPassword().getPass());
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