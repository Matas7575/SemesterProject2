import model.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SongTest {
    private Artist artist = new Solo(new User(1, new Username("Michael Jackson"), new Email("michaeljackson@gmail.com"), new Password("password")), "Michael Jackson");

    @Test
    void constructor_Z() {
        assertDoesNotThrow(() -> new Song(0, null, null, null, null));
    }

    @Test
    void constructor_O() {
        assertDoesNotThrow(() -> new Song(1, "Billie Jean", artist, "06:42", "Somewhere"));
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
    void getId_Z() {
        Song song = new Song(0, null, null, null, null);
        assertEquals(0, song.getId());
    }

    @Test
    void getId_O() {
        Song song = new Song(1, "Billie Jean", artist, "06:42", "Somewhere");
        assertEquals(1, song.getId());
    }

    @Test
    void getId_M() {
        //not relevant
    }

    @Test
    void getId_B() {
        //not relevant
    }

    @Test
    void getId_E() {
        //not relevant
    }

    @Test
    void getName_Z() {
        Song song = new Song(0, null, null, null, null);
        assertNull(song.getName());
    }
    @Test
    void getName_O() {
        Song song = new Song(1, "Billie Jean", artist, "06:42", "Somewhere");
        assertEquals("Billie Jean", song.getName());
    }
    @Test
    void getName_M() {
        //not relevant
    }
    @Test
    void getName_B() {
        //not relevant
    }
    @Test
    void getName_E() {
        //not relevant
    }

    @Test
    void getArtist_Z() {
        Song song = new Song(0, null, null, null, null);
        assertNull(song.getArtist());
    }

    @Test
    void getArtist_O() {
        Song song = new Song(1, "Billie Jean", artist, "06:42", "Somewhere");
        assertEquals(artist, song.getArtist());
    }

    @Test
    void getArtist_M() {
        //not relevant
    }

    @Test
    void getArtist_B() {
        //not relevant
    }

    @Test
    void getArtist_E() {
        //not relevant
    }


    @Test
    void getLength_Z() {
        Song song = new Song(0, null, null, null, null);
        assertNull(song.getLength());
    }

    @Test
    void getLength_O() {
        Song song = new Song(1, "Billie Jean", artist, "06:42", "Somewhere");
        assertEquals("06:42", song.getLength());
    }

    @Test
    void getLength_M() {
        //not relevant
    }

    @Test
    void getLength_B() {
        //not relevant
    }
    @Test
    void getLength_E() {
        //not relevant
    }
    @Test
    void getPath_Z() {
        Song song = new Song(0, null, null, null, null);
        assertEquals("path", song.getPath());
    }
    @Test
    void getPath_O() {
        Song song = new Song(1, "Billie Jean", artist, "06:42", "Somewhere");
        assertEquals("Somewhere", song.getPath());
    }
    @Test
    void getPath_M() {
        //not relevant
    }
    @Test
    void getPath_B() {
        //not relevant
    }
    @Test
    void getPath_E() {
        //not relevant
    }
}