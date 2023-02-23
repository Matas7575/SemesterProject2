package model;

import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class MainModelManagerTest {
    private MainModelManager mainModelManager = new MainModelManager();
    @Test
    void getCurrentlyPlaying() {
    }

    @Test
    void getLyrics() {
    }

    @Test
    void getMP3() {
    }

    @Test
    void togglePlayPause() {
    }

    @Test
    void previousSong() {
    }

    @Test
    void repeatSong() {
    }

    @Test
    void shuffleSong() {
    }

    @Test
    void getAllSongs() {
    }

    @Test
    void getSong() {
    }

    @Test
    void getPlayLists() {
    }

    @Test
    void getPlayList() {
    }
    //can't test because this is method only works on some computers and only with a certain server on, so it doesn't need to be tested in junit
    @Test
    void loadAllSongsFromDatabase() throws SQLException {
        System.out.println(mainModelManager.loadAllSongsFromDatabase());
    }
}