package resources.MusicAPI;

import jaco.mp3.player.MP3Player;
import utility.observer.javaobserver.NamedPropertyChangeSubject;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.File;


public class MP3 implements NamedPropertyChangeSubject, Runnable {
    private MP3Player mp3;
    private int timer;
    private PropertyChangeSupport property;

    public MP3() {
        mp3 = new MP3Player();
        timer = 0;
        property = new PropertyChangeSupport(this);
    }

    public void playSong(String path) {
        mp3.addToPlayList(new File(path));
        mp3.play();
    }

    public void next() {
        mp3.skipForward();
        timer = 0;
    }

    public void pauseSong() {
        mp3.pause();
    }

    @Override
    public void addListener(String propertyName, PropertyChangeListener listener) {
        property.addPropertyChangeListener(propertyName, listener);
    }

    @Override
    public void removeListener(String propertyName, PropertyChangeListener listener) {
        property.removePropertyChangeListener(propertyName, listener);
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1000);
                timer++;
                String format;
                int seconds = timer % 60;
                int minutes = timer / 60;
                if (seconds < 10) {
                    format = "0" + minutes + ":0" + seconds;
                } else {
                    format = "0" + minutes + ":" + seconds;
                }
                property.firePropertyChange("timer", null, format);
                if (mp3.isPaused()) {
                    Thread.currentThread().stop();
                }
            } catch (InterruptedException | IllegalMonitorStateException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
