package view;

import javafx.beans.binding.Bindings;
import javafx.beans.property.Property;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Region;
import viewmodel.MainViewModel;
import viewmodel.SongTableRow;
import viewmodel.ViewModelFactory;

public class MainViewController extends ViewController {
    @FXML
    private ListView playlistView;
    @FXML
    private Label songLabel;
    @FXML
    private Label userHey;
    @FXML
    private Label timeFromStart;
    @FXML
    private TableView<SongTableRow> songView;
    @FXML
    private TableColumn<SongTableRow,String> songColumn;
    @FXML
    private TableColumn<SongTableRow,String> artistColumn;
    @FXML
    private TableColumn<SongTableRow,String> lengthColumn;
    @FXML
    private Button playButton;
    @FXML
    private Button backButton;
    @FXML
    private Button shuffleButton;
    @FXML
    private Button skipButton;
    @FXML
    private Button likeButton;
    @FXML
    private ToggleButton repeat;
    @FXML
    private TextField searchBar;
    @FXML
    private ChoiceBox searchChoice;
    @FXML
    private Label showLyricsLabel;

    private Region root;
    private ViewHandler viewHandler;
    private ViewModelFactory viewModelFactory;
    private MainViewModel mainViewModel;

    private FilteredList<SongTableRow> flSongs;

    public MainViewController() {
    }

    public void init(ViewHandler viewHandler, ViewModelFactory viewModelFactory, Region root) {
        this.viewHandler = viewHandler;
        this.viewModelFactory = viewModelFactory;
        this.root = root;
        System.out.println("Nickname: "+root);
        this.mainViewModel = viewModelFactory.getMainViewModel();
        init();
    }

    @Override
    public Region getRoot() {
        return root;
    }

    @Override
    protected void init() {
        songColumn.setCellValueFactory(new PropertyValueFactory<SongTableRow,String>("name"));
        artistColumn.setCellValueFactory(new PropertyValueFactory<SongTableRow,String>("aName"));
        lengthColumn.setCellValueFactory(new PropertyValueFactory<SongTableRow,String>("length"));
        songColumn.textProperty().bindBidirectional(mainViewModel.songColumnProperty());
        artistColumn.textProperty().bindBidirectional(mainViewModel.artistColumnProperty());
        lengthColumn.textProperty().bindBidirectional(mainViewModel.lengthColumnProperty());
        flSongs = new FilteredList(mainViewModel.getSongViewProperty(), p -> true); //Pass the data to a filtered list
        songView.setItems(flSongs);
        mainViewModel.selectedItemProperty().bind(songView.getSelectionModel().selectedItemProperty());
        songLabel.textProperty().bindBidirectional(viewModelFactory.getMainViewModel().songLabelProperty());
        userHey.textProperty().bind(mainViewModel.userHeyProperty());
        timeFromStart.textProperty().bind(mainViewModel.timeFromStartProperty());
        playlistView.itemsProperty().bind(Bindings.createObjectBinding(mainViewModel::getPlaylistViewProperty));
        playButton.graphicProperty().bindBidirectional(mainViewModel.playButtonProperty());
        backButton.setGraphic(new ImageView(mainViewModel.backButtonProperty().get()));
        shuffleButton.setGraphic(new ImageView(mainViewModel.shuffleButtonProperty().get()));
        skipButton.setGraphic(new ImageView(mainViewModel.skipButtonProperty().get()));
        repeat.setGraphic(new ImageView(mainViewModel.repeatButtonProperty().get()));
        searchBar.textProperty().bindBidirectional(mainViewModel.searchBarProperty());
        searchChoice.itemsProperty().bind(Bindings.createObjectBinding(mainViewModel::getSearchChoiceProperty));
        searchChoice.getItems().addAll("Title", "Artist");
        searchChoice.setValue("Title");
        searchBar.textProperty().addListener((obs, oldValue, newValue) -> {
            Object value = searchChoice.getValue();//Switch on choiceBox value
            if ("Title".equals(value)) {
                flSongs.setPredicate(p -> p.getName().toLowerCase().contains(newValue.toLowerCase().trim()));//filter table by title
            } else if ("Artist".equals(value)) {
                flSongs.setPredicate(p -> p.getAName().toLowerCase().contains(newValue.toLowerCase().trim()));//filter table by artist
            }
        });
        searchChoice.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) -> {//reset table and searchbar when new choice is selected
            if (newVal != null) {
                searchBar.setText("");
            }
        });
    }

    @Override
    public void reset() {

    }

    @FXML
    private void onEnter(ActionEvent actionEvent) {

    }

    @FXML
    private void playPressed(){
        mainViewModel.togglePlaying();
    }

    @FXML
    private void backPressed(){
        mainViewModel.backPressed();
        songView.getSelectionModel().select(songView.getSelectionModel().getSelectedIndex()-1);
    }

    @FXML
    private void skipPressed(){
        mainViewModel.nextPressed();
        songView.getSelectionModel().select(songView.getSelectionModel().getSelectedIndex()+1);
    }

    @FXML
    private void repeatPressed(){
        mainViewModel.repeat();
    }

    @FXML
    private void mutePressed(){}

    @FXML
    private void shufflePressed(){}

    @FXML
    private void likedSongsPressed()
    {
        mainViewModel.likedButtonPressed();
    }

    @FXML
    private void allSongsPressed(){
        mainViewModel.getAllSongs();
    }

    @FXML
    private void createPlaylistPressed(){}

    @FXML private void showLyricsLabel() {
        viewHandler.openView("Chad_music_lyrics_tab.fxml");
        mainViewModel.showLyricsPressed();
    }
}
