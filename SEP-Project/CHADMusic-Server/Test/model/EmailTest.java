package model;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmailTest {

    @Test
    void constructor_Z() {
        assertDoesNotThrow(() -> new Email(""));
    }

    @Test
    void constructor_O() {
        assertDoesNotThrow(() -> new Email("email"));
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
    void getEmail_Z() {
        Email email = new Email("");
        assertEquals("", email.getEmail());
    }

    @Test
    void getEmail_O() {
        Email email = new Email("email");
        assertEquals("email", email.getEmail());
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
    void setEmail_Z() {
        Email email = new Email("email");
        assertDoesNotThrow(() -> email.setEmail(""));
    }

    @Test
    void setEmail_O() {
        Email email = new Email("email");
        assertDoesNotThrow(() -> email.setEmail("emailAgain"));
    }

    @Test
    void setEmail_M() {
        //not relevant
    }

    @Test
    void setEmail_B() {
        //not relevant
    }

    @Test
    void setEmail_E() {
        //not relevant
    }
}