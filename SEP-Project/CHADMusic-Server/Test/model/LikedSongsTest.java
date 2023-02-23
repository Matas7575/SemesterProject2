package model;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LikedSongsTest {
    Song song = new Song(1, "Billie Jean", new Solo(new User(1, new Username("Michael Jackson"), new Email("michaeljackson@gmail.com"), new Password("password")), "Michael Jackson"), "00:06:42", "somewhere over the rainbow");
    Song song2 = new Song(1, "Billie Jean", new Solo(new User(1, new Username("Michael Jackson"), new Email("michaeljackson@gmail.com"), new Password("password")), "Michael Jackson"), "00:06:42", "somewhere over the rainbow");
    Song song3 = new Song(1, "Billie Jean", new Solo(new User(1, new Username("Michael Jackson"), new Email("michaeljackson@gmail.com"), new Password("password")), "Michael Jackson"), "00:06:42", "somewhere over the rainbow");
    Song song4 = new Song(1, "Billie Jean", new Solo(new User(1, new Username("Michael Jackson"), new Email("michaeljackson@gmail.com"), new Password("password")), "Michael Jackson"), "00:06:42", "somewhere over the rainbow");

    @Test
    void constructor_Z() {
        assertDoesNotThrow(() -> new LikedSongs());
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
        LikedSongs likedSongs = new LikedSongs();
        assertDoesNotThrow(() -> likedSongs.addSong(null));
    }

    @Test
    void addSong_O() {
        LikedSongs likedSongs = new LikedSongs();
        assertDoesNotThrow(() -> likedSongs.addSong(song));
    }

    @Test
    void addSong_M() {
        LikedSongs likedSongs = new LikedSongs();
        assertDoesNotThrow(() -> {
            likedSongs.addSong(song);
            likedSongs.addSong(song2);
            likedSongs.addSong(song3);
            likedSongs.addSong(song4);
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
    void removeSong_Z() {
        LikedSongs likedSongs = new LikedSongs();
        assertDoesNotThrow(() -> likedSongs.removeSong(null));
    }

    @Test
    void removeSong_O() {
        LikedSongs likedSongs = new LikedSongs();
        likedSongs.addSong(song);
        assertDoesNotThrow(() -> likedSongs.removeSong(song));
    }

    @Test
    void removeSong_M() {
        LikedSongs likedSongs = new LikedSongs();
        likedSongs.addSong(song);
        likedSongs.addSong(song2);
        likedSongs.addSong(song3);
        likedSongs.addSong(song4);
        assertDoesNotThrow(() -> {
            likedSongs.removeSong(song);
            likedSongs.removeSong(song2);
            likedSongs.removeSong(song3);
            likedSongs.removeSong(song4);
        });
    }

    @Test
    void removeSong_B() {
        LikedSongs likedSongs = new LikedSongs();
        likedSongs.addSong(song);
        likedSongs.addSong(song2);
        likedSongs.addSong(song3);
        assertDoesNotThrow(() -> {
            likedSongs.removeSong(song);
            likedSongs.removeSong(song2);
            likedSongs.removeSong(song3);
            likedSongs.removeSong(song4);
        });
    }

    @Test
    void removeSong_E() {
        //already tested in B
    }

    @Test
    void getSong_Z() {
        LikedSongs likedSongs = new LikedSongs();
        assertThrows(Exception.class, () -> likedSongs.getSong(0));
    }

    @Test
    void getSong_O() {
        LikedSongs likedSongs = new LikedSongs();
        likedSongs.addSong(song);
        assertDoesNotThrow(() -> likedSongs.getSong(0));
    }

    @Test
    void getSong_M() {
        LikedSongs likedSongs = new LikedSongs();
        for (int i = 0; i < 3; i++) {
            likedSongs.addSong(song);
        }
        assertDoesNotThrow(() -> {
            for (int i = 0; i < 3; i++) {
                likedSongs.getSong(i);
            }
        });
    }

    @Test
    void getSong_B() {
        LikedSongs likedSongs = new LikedSongs();
        assertThrows(Exception.class, () -> likedSongs.getSong(-6));
    }

    @Test
    void getSong_E() {
        //already tested in Z and B
    }

    @Test
    void getAllSongs_Z() {
        LikedSongs likedSongs = new LikedSongs();
        assertDoesNotThrow(() -> likedSongs.getAllSongs());
    }

    @Test
    void getAllSongs_O() {
        LikedSongs likedSongs = new LikedSongs();
        likedSongs.addSong(song);
        assertDoesNotThrow(() -> likedSongs.getAllSongs());
    }

    @Test
    void getAllSongs_M() {
        LikedSongs likedSongs = new LikedSongs();
        likedSongs.addSong(song);
        likedSongs.addSong(song);
        likedSongs.addSong(song);
        assertDoesNotThrow(() -> likedSongs.getAllSongs());
    }

    @Test
    void getAllSongs_B() {
        //not relevant
    }

    @Test
    void getAllSongs_E() {
        //not relevant
    }
}