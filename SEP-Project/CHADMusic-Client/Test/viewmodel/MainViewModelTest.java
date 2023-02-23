package viewmodel;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MainViewModelTest
{
    private MainViewModel mainViewModel;
    private MainModel model;
    @BeforeEach
    public void setup()
    {
        this.model = new MainModelManager();
        this.mainViewModel = new MainViewModel(model);
    }
    @Test
    public void SetPlaying()
    {
        //arrange
        Artist artist = new Artist() {
            @Override
            public String getAName() {
                return null;
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
        Song song = new Song(1, "billie jean", artist, "2:00:00", "path");

        //act
        model.setCurrentlyPlaying(song);

        //assert
        assertNotNull(model.getCurrentlyPlaying());

    }
    @Test
    public void togglePlaying()
    {
        //arrange
        Artist artist = new Artist() {
            @Override
            public String getAName() {
                return null;
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
        Song song = new Song(1, "billie jean", artist, "2:00:00", "path");
        ObjectProperty<SongTableRow> selectedItem = new SimpleObjectProperty<>();
        mainViewModel.selectedItemProperty().bind(selectedItem);
        //act
        selectedItem.set(new SongTableRow(song));
        model.setCurrentlyPlaying(song);
        mainViewModel.togglePlaying();

        //assert
        assertTrue(model.getPlaying());
    }

    @Test
    public void togglePause()
    {
        //arrange
        Artist artist = new Artist() {
            @Override
            public String getAName() {
                return null;
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
        Song song = new Song(1, "billie jean", artist, "2:00:00", "path");
        ObjectProperty<SongTableRow> selectedItem = new SimpleObjectProperty<>();
        mainViewModel.selectedItemProperty().bind(selectedItem);
        //act
        selectedItem.set(new SongTableRow(song));
        model.setCurrentlyPlaying(song);
        mainViewModel.togglePlaying();
        mainViewModel.togglePlaying();

        //assert
        assertFalse(model.getPlaying());
    }

    @Test
    public void skipSong()
    {
        //arrange
        Artist artist = new Artist() {
            @Override
            public String getAName() {
                return null;
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
        Song song = new Song(1, "billie jean", artist, "2:00:00", "path");
        ObjectProperty<SongTableRow> selectedItem = new SimpleObjectProperty<>();
        mainViewModel.selectedItemProperty().bind(selectedItem);

        //act
        selectedItem.set(new SongTableRow(song));
        model.setCurrentlyPlaying(song);
        mainViewModel.nextPressed();

        //assert
        assertEquals(2,model.getCurrentlyPlaying().getId());
    }

    @Test
    public void previousSong()
    {
        //arrange
        Artist artist = new Artist() {
            @Override
            public String getAName() {
                return null;
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
        Song song = new Song(4, "billie jean", artist, "2:00:00", "path");
        ObjectProperty<SongTableRow> selectedItem = new SimpleObjectProperty<>();
        mainViewModel.selectedItemProperty().bind(selectedItem);

        //act
        selectedItem.set(new SongTableRow(song));
        model.setCurrentlyPlaying(song);
        mainViewModel.backPressed();

        //assert
        assertEquals(3,model.getCurrentlyPlaying().getId());
    }
    @Test
    public void fetchSongsFromDataBase()
    {
        System.out.println(model.getAllSongs());
        //System.out.println(model.get);
    }

    @Test
    public void setRepeating()
    {
        //arrange
        //act
        mainViewModel.repeat();
        //assert
        assertFalse(model.getRepeat());
    }
}