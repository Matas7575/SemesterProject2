package view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Region;
import viewmodel.LyricsViewModel;
import viewmodel.ViewModelFactory;

public class LyricsViewController extends ViewController {
    @FXML
    private Label songLabel;
    @FXML
    private Label timeFromStart;
    @FXML
    private Button playButton;
    @FXML
    private Button backButton;
    @FXML
    private Button shuffleButton;
    @FXML
    private Button skipButton;
    @FXML
    private ToggleButton repeat;
    @FXML
    private TextArea lyricsArea;

    private Region root;
    private ViewHandler viewHandler;
    private ViewModelFactory viewModelFactory;
    private LyricsViewModel lyricsViewModel;

    public LyricsViewController() {
    }

    public void init(ViewHandler viewHandler, ViewModelFactory viewModelFactory, Region root) {
        this.viewHandler = viewHandler;
        this.viewModelFactory = viewModelFactory;
        this.root = root;
        System.out.println("Nickname: "+root);
        this.lyricsViewModel = viewModelFactory.getLyricsViewModel();
        init();
    }

    @Override
    public Region getRoot() {
        return root;
    }

    @Override
    protected void init() {
        songLabel.textProperty().bind(viewModelFactory.getMainViewModel().songLabelProperty());
        timeFromStart.textProperty().bind(lyricsViewModel.timeFromStartProperty());
        playButton.graphicProperty().bindBidirectional(lyricsViewModel.playButtonProperty());
        backButton.setGraphic(new ImageView(lyricsViewModel.backButtonProperty().get()));
        shuffleButton.setGraphic(new ImageView(lyricsViewModel.shuffleButtonProperty().get()));
        skipButton.setGraphic(new ImageView(lyricsViewModel.skipButtonProperty().get()));
        repeat.setGraphic(new ImageView(lyricsViewModel.repeatButtonProperty().get()));
        lyricsArea.textProperty().bind(lyricsViewModel.lyricsAreaProperty());
        lyricsViewModel.togglePlaying();
    }

    @Override
    public void reset() {

    }

    @FXML
    private void onEnter(ActionEvent actionEvent) {

    }

    @FXML
    private void playPressed(){
        viewModelFactory.getMainViewModel().togglePlaying();
        lyricsViewModel.togglePlaying();
    }

    @FXML
    private void backPressed(){viewModelFactory.getMainViewModel().backPressed();}

    @FXML
    private void skipPressed(){viewModelFactory.getMainViewModel().nextPressed();}

    @FXML
    private void repeatPressed(){
        viewModelFactory.getMainViewModel().repeat();
    }

    @FXML
    private void mutePressed(){}

    @FXML
    private void shufflePressed(){}

    @FXML
    private void goBack() {
        viewHandler.openView("Chad_music_main_tab.fxml");
    }
}
