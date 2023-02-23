import model.Password;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PasswordTest {
        @Test
        void constructor_Z() {
            assertDoesNotThrow(() -> new Password(""));
        }

        @Test
        void constructor_O() {
            assertDoesNotThrow(() -> new Password("Password"));
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
        void getPassword_Z() {
            Password password = new Password("");
            assertEquals("", password.getPass());
        }

        @Test
        void getPassword_O() {
            Password Password = new Password("Password");
            assertEquals("Password", Password.getPass());
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

        @Test
        void setPassword_Z() {
            Password Password = new Password("Password");
            assertDoesNotThrow(() -> Password.setPass(""));
        }

        @Test
        void setPassword_O() {
            Password Password = new Password("Password");
            assertDoesNotThrow(() -> Password.setPass("PasswordAgain"));
        }

        @Test
        void setPassword_M() {
            //not relevant
        }

        @Test
        void setPassword_B() {
            //not relevant
        }

        @Test
        void setPassword_E() {
            //not relevant
        }
    }