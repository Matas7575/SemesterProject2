package viewmodel;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import model.MainModel;
import model.MainModelManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LyricsViewModelTest {
//this class testing for playing is already done in MainViewModelTest togglePlaying and togglePause
    private LyricsViewModel lyricsViewModel;
    private MainModel model;


    @BeforeEach
    public void setup()
    {
        this.model = new MainModelManager();
        this.lyricsViewModel = new LyricsViewModel(model);
    }

    @Test
    public void SongNotSelectedAndTryingToOpenLyrics()
    {
        //arrange
        StringProperty lyricsArea = new SimpleStringProperty();
        lyricsViewModel.lyricsAreaProperty().bindBidirectional(lyricsArea);
        //act


        //assert
        assertNull(lyricsArea.get());
        //The lyrics window will open, but the lyrics table will not show anything.
    }
}