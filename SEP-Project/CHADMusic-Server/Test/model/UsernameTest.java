package model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UsernameTest {
    @Test
    void constructor_Z() {
        assertDoesNotThrow(() -> new Username(""));
    }

    @Test
    void constructor_O() {
        assertDoesNotThrow(() -> new Username("Username"));
    }

    @Test
    void contructor_M() {
        //not relevant
    }

    @Test
    void contructor_B() {
        //not relevant
    }

    @Test
    void contructor_E() {
        //not relevant
    }

    @Test
    void getUsername_Z() {
        Username Username = new Username("");
        assertEquals("", Username.getName());
    }

    @Test
    void getUsername_O() {
        Username Username = new Username("Username");
        assertEquals("Username", Username.getName());
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
    void setUsername_Z() {
        Username Username = new Username("Username");
        assertDoesNotThrow(() -> Username.setName(""));
    }

    @Test
    void setUsername_O() {
        Username Username = new Username("Username");
        assertDoesNotThrow(() -> Username.setName("UsernameAgain"));
    }

    @Test
    void setUsername_M() {
        //not relevant
    }

    @Test
    void setUsername_B() {
        //not relevant
    }

    @Test
    void setUsername_E() {
        //not relevant
    }
}