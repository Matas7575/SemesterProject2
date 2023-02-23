package model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class PlaylistListTest {
    @Test
    void constructor_Z() {
        assertDoesNotThrow(() -> new PlaylistList());
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
    void addPlaylist_Z() {
        PlaylistList playlistList = new PlaylistList();
        assertDoesNotThrow(() -> playlistList.addPlaylist(""));
    }

    @Test
    void addPlaylist_O() {
        PlaylistList playlistList = new PlaylistList();
        assertDoesNotThrow(() -> playlistList.addPlaylist("Playlist"));
    }

    @Test
    void addPlaylist_M() {
        PlaylistList playlistList = new PlaylistList();
        assertDoesNotThrow(() -> {
            playlistList.addPlaylist("hello");
            playlistList.addPlaylist("bau");
            playlistList.addPlaylist("ciao");
        });
    }

    @Test
    void addPlaylist_B() {
        //not relevant
    }

    @Test
    void addPlaylist_E() {
        //not relevant
    }

    @Test
    void removePlaylist_Z() {
        PlaylistList playlistList = new PlaylistList();
        assertDoesNotThrow(() -> playlistList.removePlaylist(null));
    }

    @Test
    void removePlaylist_O() {
        PlaylistList playlistList = new PlaylistList();
        playlistList.addPlaylist("Playlist");
        assertDoesNotThrow(() -> playlistList.removePlaylist(new UserPlaylists("Playlist")));
    }

    @Test
    void removePlaylist_M() {
        PlaylistList playlistList = new PlaylistList();
        playlistList.addPlaylist("Playlist");
        playlistList.addPlaylist("Playlist2");
        playlistList.addPlaylist("Playlist3");
        playlistList.addPlaylist("Playlist4");
        assertDoesNotThrow(() -> {
            playlistList.removePlaylist(new UserPlaylists("Playlist"));
            playlistList.removePlaylist(new UserPlaylists("Playlist2"));
            playlistList.removePlaylist(new UserPlaylists("Playlist3"));
            playlistList.removePlaylist(new UserPlaylists("Playlist4"));
        });
    }

    @Test
    void removePlaylist_B() {
        PlaylistList playlistList = new PlaylistList();
        playlistList.addPlaylist("Playlist");
        playlistList.addPlaylist("Playlist2");
        playlistList.addPlaylist("Playlist3");
        assertDoesNotThrow(() -> {
            playlistList.removePlaylist(new UserPlaylists("Playlist"));
            playlistList.removePlaylist(new UserPlaylists("Playlist2"));
            playlistList.removePlaylist(new UserPlaylists("Playlist3"));
            playlistList.removePlaylist(new UserPlaylists("Playlist4"));
        });
    }

    @Test
    void removePlaylist_E() {
        //already tested in B
    }

    @Test
    void getPlaylist_Z() {
        PlaylistList playlistList = new PlaylistList();
        playlistList.addPlaylist("Playlist");
        assertDoesNotThrow(() -> playlistList.getPlaylist(0));
    }

    @Test
    void getPlaylist_O() {
        PlaylistList playlistList = new PlaylistList();
        playlistList.addPlaylist("Playlist");
        playlistList.addPlaylist("Playlist");
        assertDoesNotThrow(() -> playlistList.getPlaylist(1));
    }

    @Test
    void getPlaylist_M() {
        PlaylistList playlistList = new PlaylistList();
        playlistList.addPlaylist("Playlist");
        playlistList.addPlaylist("Playlist");
        assertDoesNotThrow(() -> {
            playlistList.getPlaylist(1);
            playlistList.getPlaylist(0);
        });
    }

    @Test
    void getPlaylist_B() {
        PlaylistList playlistList = new PlaylistList();
        assertThrows(Exception.class, () -> playlistList.getPlaylist(-6));
    }

    @Test
    void getPlaylist_E() {
        //already tested in B
    }

    @Test
    void getAllPlaylists_Z() {
        PlaylistList playlistList = new PlaylistList();
        assertDoesNotThrow(() -> playlistList.getAllPlaylists());
    }

    @Test
    void getAllPlaylists_O() {
        PlaylistList playlistList = new PlaylistList();
        assertDoesNotThrow(() -> playlistList.getAllPlaylists());
    }

    @Test
    void getAllPlaylists_M() {
        //not relevant
    }

    @Test
    void getAllPlaylists_B() {
        //not relevant
    }

    @Test
    void getAllPlaylists_E() {
        //not relevant
    }

    @Test
    void playlistsSize_Z() {
        PlaylistList playlistList = new PlaylistList();
        assertDoesNotThrow(() -> playlistList.playlistsSize());
    }

    @Test
    void playlistsSize_O() {
        PlaylistList playlistList = new PlaylistList();
        assertEquals(1, playlistList.playlistsSize());
    }

    @Test
    void playlistsSize_M() {
        //not relevant
    }

    @Test
    void playlistsSize_B() {
        //not relevant
    }

    @Test
    void playlistsSize_E() {
        //not relevant
    }
}