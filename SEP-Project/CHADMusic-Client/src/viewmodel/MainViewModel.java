package viewmodel;

import javafx.application.Platform;
import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import model.MainModel;
import model.SongList;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;

public class MainViewModel implements PropertyChangeListener {
    private StringProperty songLabelProperty;
    private StringProperty userHeyProperty;
    private StringProperty timeFromStartProperty;
    private StringProperty timeFromEndProperty;
    private StringProperty searchBarProperty;
    private StringProperty songColumnProperty;
    private StringProperty artistColumnProperty;
    private StringProperty lengthColumnProperty;
    private ObservableList<String> playlistViewProperty;
    private ObservableList<String> searchChoiceProperty;
    private ObservableList<SongTableRow> songViewProperty;
    private ObjectProperty<Node> playButtonProperty;
    private ObjectProperty<Image> backButtonProperty;
    private ObjectProperty<Image> skipButtonProperty;
    private ObjectProperty<Image> shuffleButtonProperty;
    private ObjectProperty<Image> repeatButtonProperty;
    private ObjectProperty<Image> muteButtonProperty;
    private ObjectProperty<Image> songPictureProperty;
    private ObjectProperty<Image> likedSongProperty;
    private ObjectProperty<SongTableRow> selectedItem;
    private MainModel model;

    public MainViewModel(MainModel model) {
        this.model = model;
        model.getMP3().addListener("timer", this);
        model.addListener("songList", this);
        songViewProperty = FXCollections.observableArrayList();
        songLabelProperty = new SimpleStringProperty();
        userHeyProperty = new SimpleStringProperty("Hey there friend! :)");
        timeFromStartProperty = new SimpleStringProperty();
        timeFromEndProperty = new SimpleStringProperty();
        searchBarProperty = new SimpleStringProperty();
        songColumnProperty = new SimpleStringProperty("Name");
        artistColumnProperty = new SimpleStringProperty("Artist");
        lengthColumnProperty = new SimpleStringProperty("Length");
        playlistViewProperty = FXCollections.observableArrayList();
        searchChoiceProperty = FXCollections.observableArrayList();
        playButtonProperty = new SimpleObjectProperty<>(new ImageView(new Image("play.png")));
        backButtonProperty = new SimpleObjectProperty<>(new Image("backwards.png"));
        skipButtonProperty = new SimpleObjectProperty<>(new Image("forward.png"));
        shuffleButtonProperty = new SimpleObjectProperty<>();
        repeatButtonProperty = new SimpleObjectProperty<>(new Image("repeat.png"));
        muteButtonProperty = new SimpleObjectProperty<>();
        songPictureProperty = new SimpleObjectProperty<>();
        likedSongProperty = new SimpleObjectProperty<>();
        selectedItem = new SimpleObjectProperty<>();
    }

    public void setUserHeyProperty(String user) {
        userHeyProperty.set("Hello there, "+ user + "!");
    }

    public ObjectProperty<SongTableRow> selectedItemProperty() {
        return selectedItem;
    }

    public StringProperty songLabelProperty() {
        return songLabelProperty;
    }

    public StringProperty userHeyProperty() {
        return userHeyProperty;
    }

    public StringProperty timeFromStartProperty() {
        return timeFromStartProperty;
    }

    public StringProperty timeFromEndProperty() {
        return timeFromEndProperty;
    }

    public StringProperty searchBarProperty() {
        return searchBarProperty;
    }

    public StringProperty songColumnProperty() {
        return songColumnProperty;
    }

    public StringProperty artistColumnProperty() {
        return artistColumnProperty;
    }

    public StringProperty lengthColumnProperty() {
        return lengthColumnProperty;
    }

    public ObservableList<String> getPlaylistViewProperty() {
        return playlistViewProperty;
    }

    public ObservableList<String> getSearchChoiceProperty() {
        return searchChoiceProperty;
    }

    public ObservableList<SongTableRow> getSongViewProperty() {
        return songViewProperty;
    }

    public ObjectProperty<Node> playButtonProperty() {
        return playButtonProperty;
    }

    public ObjectProperty<Image> backButtonProperty() {
        return backButtonProperty;
    }

    public ObjectProperty<Image> skipButtonProperty() {
        return skipButtonProperty;
    }

    public ObjectProperty<Image> shuffleButtonProperty() {
        return shuffleButtonProperty;
    }

    public ObjectProperty<Image> repeatButtonProperty() {
        return repeatButtonProperty;
    }

    public ObjectProperty<Image> muteButtonProperty() {
        return muteButtonProperty;
    }

    public ObjectProperty<Image> songPictureProperty() {
        return songPictureProperty;
    }
    public ObjectProperty<Image> LikedSongProperty()
    {
        return likedSongProperty;
    }


    public void showLyricsPressed() {
        model.getLyrics(model.getCurrentlyPlaying().getName() + " " + model.getCurrentlyPlaying().getArtist().getAName());
    }

    public void startPlayingSelectedSong() {
        SongList songList = model.getAllSongs();
        for (int i = 0; i < songList.size(); i++) {
            if (songList.getSong(i).getName().equals(selectedItem.get().getName()) && songList.getSong(i).getArtist().getAName().equals(selectedItem.get().getAName())) {
                model.setCurrentlyPlaying(songList.getSong(i));
                songLabelProperty.set(model.getCurrentlyPlaying().getName() + " - " + model.getCurrentlyPlaying().getArtist().getAName());
                System.out.println("We got into the for loop");
                playButtonProperty.setValue(new ImageView(new Image("pause.png")));
                break;
            }
        }
    }

    public void repeat() {
        model.setRepeat();
    }

    public void togglePlaying() {
        if (selectedItem == null)
            throw new IllegalStateException("No selected song");
        if (model.getCurrentlyPlaying() == null)
            startPlayingSelectedSong();
        else if (!(model.getCurrentlyPlaying().getName().equalsIgnoreCase(selectedItem.get().getName())))
            startPlayingSelectedSong();
        else {
            if (!model.getPlaying()) {
                playButtonProperty.setValue(new ImageView(new Image("pause.png")));
            } else {
                playButtonProperty.setValue(new ImageView(new Image("play.png")));
            }
            model.togglePlayPause();
        }
    }

    public void getAllSongs() {
        model.getAllSongs();
    }

    public void nextPressed() {
        model.setCurrentlyPlaying(model.getAllSongs().getSong(model.getCurrentlyPlaying().getId()));
        songLabelProperty.set(model.getCurrentlyPlaying().getName() + " - " + model.getCurrentlyPlaying().getArtist().getAName());
        playButtonProperty.setValue(new ImageView(new Image("pause.png")));
        model.getLyrics(model.getCurrentlyPlaying().getName() + " " + model.getCurrentlyPlaying().getArtist().getAName());
    }
    public void backPressed() {
        model.setCurrentlyPlaying(model.getAllSongs().getSong(model.getCurrentlyPlaying().getId()-2));
        songLabelProperty.set(model.getCurrentlyPlaying().getName() + " - " + model.getCurrentlyPlaying().getArtist().getAName());
        playButtonProperty.setValue(new ImageView(new Image("pause.png")));
        model.getLyrics(model.getCurrentlyPlaying().getName() + " " + model.getCurrentlyPlaying().getArtist().getAName());
    }
    public void likedButtonPressed()
    {
        model.addToLikedSongs(model.getCurrentlyPlaying());
        System.out.println("song is added" + model.getCurrentlyPlaying().getName());
    }
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        Platform.runLater(() -> {
            switch (evt.getPropertyName()) {
                case "timer" -> {
                    timeFromStartProperty.set(String.valueOf(evt.getNewValue()));
                    if(model.getCurrentlyPlaying().getLength().equalsIgnoreCase((String)evt.getNewValue()+":00") && !model.getRepeat()) {
                        nextPressed();
                    }
                }
                case "songList" -> {
                    SongList songList = (SongList) evt.getNewValue();
                    System.out.println(songList);
                    for (int i = 0; i < songList.size(); i++) {
                        SongTableRow songTableRow = new SongTableRow(songList.getSong(i));
                        System.out.println(songTableRow);
                        songViewProperty.add(songTableRow);
                    }
                }
            }
        });
    }
}
