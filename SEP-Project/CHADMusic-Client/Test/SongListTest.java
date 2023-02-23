import model.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SongListTest {
    Song song = new Song(1, "Billie Jean", new Solo(new User(1, new Username("Michael Jackson"), new Email("michaeljackson@gmail.com"), new Password("password")), "Michael Jackson"), "00:06:42", "somewhere over the rainbow");
    Song song2 = new Song(1, "Billie Jean", new Solo(new User(1, new Username("Michael Jackson"), new Email("michaeljackson@gmail.com"), new Password("password")), "Michael Jackson"), "00:06:42", "somewhere over the rainbow");
    Song song3 = new Song(1, "Billie Jean", new Solo(new User(1, new Username("Michael Jackson"), new Email("michaeljackson@gmail.com"), new Password("password")), "Michael Jackson"), "00:06:42", "somewhere over the rainbow");
    Song song4 = new Song(1, "Billie Jean", new Solo(new User(1, new Username("Michael Jackson"), new Email("michaeljackson@gmail.com"), new Password("password")), "Michael Jackson"), "00:06:42", "somewhere over the rainbow");

    void constructor_Z() {
        assertDoesNotThrow(() -> new SongList());
    }

    @Test
    void constructor_O() {
        //not relevant since constructor takes no arguments
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
    void addSong_Z() {
        SongList songList = new SongList();
        assertDoesNotThrow(() -> songList.addSong(null));
    }

    @Test
    void addSong_O() {
        SongList songList = new SongList();
        assertDoesNotThrow(() -> songList.addSong(song));
    }

    @Test
    void addSong_M() {
        SongList songList = new SongList();
        assertDoesNotThrow(() -> {
            songList.addSong(song);
            songList.addSong(song2);
            songList.addSong(song3);
            songList.addSong(song4);
        });
    }

    @Test
    void addSong_B() {
        //not relevant
    }

    @Test
    void addSong_E() {
        //not relevant
    }

    @Test
    void getSong_Z() {
        SongList songList = new SongList();
        assertThrows(Exception.class, () -> songList.getSong(0));
    }

    @Test
    void getSong_O() {
        SongList songList = new SongList();
        songList.addSong(song);
        assertDoesNotThrow(() -> songList.getSong(0));
    }

    @Test
    void getSong_M() {
        SongList songList = new SongList();
        for (int i = 0; i < 3; i++) {
            songList.addSong(song);
        }
        assertDoesNotThrow(() -> {
            for (int i = 0; i < 3; i++) {
                songList.getSong(i);
            }
        });
    }

    @Test
    void getSong_B() {
        SongList songList = new SongList();
        assertThrows(Exception.class, () -> songList.getSong(-6));
    }

    @Test
    void getSong_E() {
        //already tested in Z and B
    }

    @Test
    void getAllSongs_Z() {
        SongList songList = new SongList();
        assertDoesNotThrow(() -> songList.getAllSongs());
    }

    @Test
    void getAllSongs_O() {
        SongList songList = new SongList();
        songList.addSong(song);
        assertDoesNotThrow(() -> songList.getAllSongs());
    }

    @Test
    void getAllSongs_M() {
        SongList songList = new SongList();
        songList.addSong(song);
        songList.addSong(song2);
        songList.addSong(song3);
        assertDoesNotThrow(() -> songList.getAllSongs());
    }

    @Test
    void getAllSongs_B() {
        //not relevant
    }

    @Test
    void getAllSongs_E() {
        //not relevant
    }


    @Test
    void size_Z() {
        SongList songList = new SongList();
        assertEquals(0,songList.size());
    }

    @Test
    void size_O() {
        SongList songList = new SongList();
        songList.addSong(song);
        assertEquals(1,songList.size());
    }

    @Test
    void size_M() {
        SongList songList = new SongList();
        songList.addSong(song);
        songList.addSong(song2);
        songList.addSong(song3);
        assertEquals(3,songList.size());
    }

    @Test
    void size_B() {
        //not relevant
    }

    @Test
    void size_E() {
        //not relevant
    }

    @Test
    void isEmpty_Z() {
        SongList songList = new SongList();
        assertTrue(songList.isEmpty());
    }

    @Test
    void isEmpty_O() {
        SongList songList = new SongList();
        songList.addSong(song);
        assertFalse(songList.isEmpty());
    }

    @Test
    void isEmpty_M() {
        SongList songList = new SongList();
        songList.addSong(song);
        songList.addSong(song2);
        songList.addSong(song3);
        assertFalse(songList.isEmpty());
    }

    @Test
    void isEmpty_B() {
        //not relevant
    }

    @Test
    void isEmpty_E() {
        //not relevant
    }
}