import model.Password;
import model.Player;
import model.Playlist;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    @Test
    void constructor_Z() {
        assertDoesNotThrow(() -> new Player());
    }

    @Test
    void constructor_O() {
        //not relevant
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
    void setPlaying_Z() {
        Player player = new Player();
        assertDoesNotThrow(()-> player.setPlaying(""));
    }

    @Test
    void setPlaying_O() {
        Player player = new Player();
        assertDoesNotThrow(()-> player.setPlaying("D:\\VIA\\SEP2\\SEP-Project\\CHADMusic-Client\\song.mp3"));
    }

    @Test
    void setPlaying_M() {
        //not relevant
    }

    @Test
    void setPlaying_B() {
        //not relevant
    }

    @Test
    void setPlaying_E() {
        //not relevant
    }

    @Test
    void next_Z() {
        Player player = new Player();
        assertDoesNotThrow(() -> player.next());
    }

    @Test
    void next_O() {
        //not relevant
    }

    @Test
    void next_M() {
        //not relevant
    }

    @Test
    void next_B() {
        //not relevant
    }

    @Test
    void next_E() {
        //not relevant
    }

    @Test
    void pausePlaying_Z() {
        Player player = new Player();
        assertDoesNotThrow(() -> player.pausePlaying());
    }

    @Test
    void pausePlaying_O() {
        //not relevant
    }

    @Test
    void pausePlaying_M() {
        //not relevant
    }

    @Test
    void pausePlaying_B() {
        //not relevant
    }

    @Test
    void pausePlaying_E() {
        //not relevant
    }

    @Test
    void getMp3_Z() {
        Player player = new Player();
        assertDoesNotThrow(() -> player.getMp3());
    }

    @Test
    void getMp3_O() {
        //not relevant
    }

    @Test
    void getMp3_M() {
        //not relevant
    }

    @Test
    void getMp3_B() {
        //not relevant
    }

    @Test
    void getMp3_E() {
        //not relevant
    }
}