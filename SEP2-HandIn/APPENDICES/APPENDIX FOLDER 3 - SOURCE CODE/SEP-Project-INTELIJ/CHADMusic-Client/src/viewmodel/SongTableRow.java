package viewmodel;

import javafx.beans.property.Property;
import model.Song;

public class SongTableRow {
    private Song song;
    public SongTableRow(Song song) {
        this.song = song;
    }

    public Song getSong() {
        return song;
    }
    public int getId() {
        return song.getId();
    }

    public String getName() {
        return song.getName();
    }

    public String getAName() {
        return song.getArtist().getAName(); }

    public String getLength() {
        return song.getLength();
    }

    public String getPath() {
        return song.getPath();
    }

    @Override
    public String toString() {
        return song.toString();
    }
}
