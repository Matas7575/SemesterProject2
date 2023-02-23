import model.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {
    private Username username = new Username("debil");
    private Password password = new Password("yes");
    private Email email = new Email("a");

    @Test
    void getLikedSongsPlaylist_Z() {
        User user = new User(0, null, null, null);
        assertDoesNotThrow(() -> user.getLikedSongsPlaylist());
    }

    @Test
    void getLikedSongsPlaylist_O() {
        User user = new User(1234, username, email, password);
        assertNotNull(user.getLikedSongsPlaylist());
    }

    @Test
    void getLikedSongsPlaylist_M() {
        //not relevant
    }

    @Test
    void getLikedSongsPlaylist_B() {
        //not relevant
    }

    @Test
    void getLikedSongsPlaylist_E() {
        //not relevant
    }

    @Test
    void getPlaylist_Z() {
        User user = new User(0, null, null, null);
        assertDoesNotThrow(() -> user.getPlaylist(0));
    }

    @Test
    void getPlaylist_O() {
        User user = new User(1234, username, email, password);
        user.createPlaylist("yes");
        assertDoesNotThrow(() -> user.getPlaylist(0));
    }

    @Test
    void getPlaylist_M() {
        User user = new User(1234, username, email, password);
        user.createPlaylist("yes");
        user.createPlaylist("no");
        user.createPlaylist("maybe?");
        assertDoesNotThrow(() -> {
            for (int i = 0; i < 3; i++) {
                user.getPlaylist(i);
            }
        });
    }

    @Test
    void getPlaylist_B() {
        User user = new User(1234, username, email, password);
        assertThrows(Exception.class, () -> user.getPlaylist(-6));
    }

    @Test
    void getPlaylist_E() {
        //tested in B
    }

    @Test
    void createPlaylist_Z() {
        User user = new User(0, null, null, null);
        assertDoesNotThrow(() -> user.createPlaylist(""));
    }

    @Test
    void createPlaylist_O() {
        User user = new User(1234, username, email, password);
        assertDoesNotThrow(() -> user.createPlaylist("playlist"));
    }

    @Test
    void createPlaylist_M() {
        User user = new User(1234, username, email, password);
        assertDoesNotThrow(() -> {
            user.createPlaylist("yes");
            user.createPlaylist("no");
            user.createPlaylist("maybe?");
        });
    }

    @Test
    void createPlaylist_B() {
        //not relevant
    }

    @Test
    void createPlaylist_E() {
        //not relevant
    }


    @Test
    void removePlaylist_Z() {
        User user = new User(0, null, null, null);
        assertDoesNotThrow(() -> user.removePlaylist(null));
    }

    @Test
    void removePlaylist_O() {
        User user = new User(1234, username, email, password);
        user.createPlaylist("playlist");
        assertDoesNotThrow(() -> user.removePlaylist(new UserPlaylists("playlist")));
    }

    @Test
    void removePlaylist_M() {
        User user = new User(1234, username, email, password);
        user.createPlaylist("yes");
        user.createPlaylist("no");
        user.createPlaylist("maybe?");
        assertDoesNotThrow(() -> {
            user.removePlaylist(new UserPlaylists("yes"));
            user.removePlaylist(new UserPlaylists("no"));
            user.removePlaylist(new UserPlaylists("maybe"));
        });
    }

    @Test
    void removePlaylist_B() {
        //not relevant
    }

    @Test
    void removePlaylist_E() {
        //not relevant
    }
}