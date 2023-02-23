import model.UserPlaylists;
import model.Username;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserPlaylistsTest {

    @Test
    void constructor_Z() {
        assertDoesNotThrow(() -> new UserPlaylists(""));
    }

    @Test
    void constructor_O() {
        assertDoesNotThrow(() -> new UserPlaylists("playlist"));
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
    void getName_Z()
    {
        UserPlaylists userPlaylists = new UserPlaylists("");
        assertEquals("",userPlaylists.getName());
    }
    @Test
    void getName_O()
    {
        UserPlaylists userPlaylists = new UserPlaylists("yes");
        assertEquals("yes",userPlaylists.getName());
    }

    @Test
    void getName_M()
    {
        //not relevant
    }

    @Test
    void getName_B()
    {
        //not relevant
    }

    @Test
    void getName_E()
    {
        //not relevant
    }
}