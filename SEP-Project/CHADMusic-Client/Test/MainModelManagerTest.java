import model.*;
import org.junit.jupiter.api.Test;
import resources.LyricsAPI.genius.SongSearch;

import static org.junit.jupiter.api.Assertions.*;

class MainModelManagerTest {
    MainModelManager mainModelManager = new MainModelManager();
    Artist artist = new Artist() {
        @Override
        public String getAName() {
            return "AC/DC";
        }

        @Override
        public int getUserId() {
            return 0;
        }

        @Override
        public Username getUsername() {
            return null;
        }

        @Override
        public Email getEmail() {
            return null;
        }

        @Override
        public Password getPassword() {
            return null;
        }
    };
    Song song = new Song(3,"Back in black",artist,"4:53","asdasd" );
    //we might not need to test this



    @Test
    void getLyrics() {
    }

    @Test
    void getMP3() {
    }

    @Test
    void setSongList() {
    }

    @Test
    void togglePlayPause() {
    }

    @Test
    void setRepeat() {
    }

    @Test
    void getRepeat() {
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
    void getPlayLists() {
    }

    @Test
    void getPlayList() {
    }

    @Test
    void getPlaying() {
    }

    @Test
    void addListener() {
    }

    @Test
    void removeListener() {
    }
}