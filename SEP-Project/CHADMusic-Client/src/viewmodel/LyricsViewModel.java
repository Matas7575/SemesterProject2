package viewmodel;

import javafx.application.Platform;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import model.MainModel;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class LyricsViewModel implements PropertyChangeListener {
    private StringProperty songLabelProperty;
    private StringProperty timeFromStartProperty;
    private ObjectProperty<Node> playButtonProperty;
    private ObjectProperty<Image> backButtonProperty;
    private ObjectProperty<Image> skipButtonProperty;
    private ObjectProperty<Image> shuffleButtonProperty;
    private ObjectProperty<Image> repeatButtonProperty;
    private ObjectProperty<Image> muteButtonProperty;
    private ObjectProperty<Image> songPictureProperty;
    private StringProperty lyricsArea;
    private MainModel model;

    public LyricsViewModel(MainModel model) {
        model.addListener("lyrics", this);
        model.getMP3().addListener("timer",this);
        this.model = model;
        songLabelProperty = new SimpleStringProperty();
        timeFromStartProperty = new SimpleStringProperty();
        lyricsArea = new SimpleStringProperty();
        playButtonProperty = new SimpleObjectProperty<>(new ImageView(new Image("play.png")));
        backButtonProperty = new SimpleObjectProperty<>(new Image("backwards.png"));
        skipButtonProperty = new SimpleObjectProperty<>(new Image("forward.png"));
        shuffleButtonProperty = new SimpleObjectProperty<>();
        repeatButtonProperty = new SimpleObjectProperty<>(new Image("repeat.png"));
        muteButtonProperty = new SimpleObjectProperty<>();
        songPictureProperty = new SimpleObjectProperty<>();
    }
    public StringProperty songLabelProperty() {
        return songLabelProperty;
    }
    public StringProperty timeFromStartProperty() {
        return timeFromStartProperty;
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

    public StringProperty lyricsAreaProperty() {
        return lyricsArea;
    }

    public void togglePlaying() {
        if(model.getPlaying()) {
            playButtonProperty.setValue(new ImageView(new Image("pause.png")));
        }
        else {
            playButtonProperty.setValue(new ImageView(new Image("play.png")));
        }
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        Platform.runLater(()->{
            switch (evt.getPropertyName()) {
                case "lyrics" -> {
                    lyricsArea.set(String.valueOf(evt.getNewValue()));
                }
                case "timer" -> {
                    timeFromStartProperty.set(String.valueOf(evt.getNewValue()));
                }
            }
        });
    }
}


