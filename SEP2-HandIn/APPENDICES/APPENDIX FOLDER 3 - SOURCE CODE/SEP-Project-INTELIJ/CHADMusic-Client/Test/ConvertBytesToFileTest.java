import collection.StringStack1;
import model.ConvertBytesToFile;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConvertBytesToFileTest {

    @Test
    void constructor_Z() {
        //not relevant since it contains only static methods
    }

    @Test
    void constructor_O() {
        //not relevant since it contains only static methods
    }

    @Test
    void contructor_M() {
        //not relevant since it contains only static methods
    }

    @Test
    void contructor_B() {
        //not relevant since it contains only static methods
    }

    @Test
    void contructor_E() {
        //not relevant since it contains only static methods
    }

    @Test
    void writeByte_Z() {
       assertThrows(RuntimeException.class, ()->ConvertBytesToFile.writeByte(null));
    }

    @Test
    void writeByte_O() {
        byte bytes[] = {20,10,30,5};
        assertDoesNotThrow(()->ConvertBytesToFile.writeByte(bytes));
    }
    @Test
    void writeByte_M() {
        //not relevant
    }
    @Test
    void writeByte_B() {
        //not relevant
    }
    @Test
    void writeByte_E() {
        //not relevant
    }
    @Test
    void sendPath_Z(){
        //since static method with static variable
        // the answer will be always the same and
        // different for every computer
    }

    @Test
    void sendPath_O(){
        //since static method with static variable
        // the answer will be always the same and
        // different for every computer
    }

    @Test
    void sendPath_M(){
        //not relevant
    }

    @Test
    void sendPath_B(){
        //not relevant
    }

    @Test
    void sendPath_E(){
        //not relevant
    }
}