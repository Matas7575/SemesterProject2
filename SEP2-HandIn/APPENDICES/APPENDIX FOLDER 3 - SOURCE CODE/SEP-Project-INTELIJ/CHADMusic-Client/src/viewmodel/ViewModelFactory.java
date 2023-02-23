package viewmodel;

import model.MainModel;

public class ViewModelFactory {
    private MainViewModel mainViewModel;
    private LyricsViewModel lyricsViewModel;
    private LoginRegisterViewModel loginRegisterViewModel;

    public ViewModelFactory(MainModel model) {
        this.mainViewModel = new MainViewModel(model);
        this.lyricsViewModel = new LyricsViewModel(model);
        this.loginRegisterViewModel = new LoginRegisterViewModel(model);
    }

    public MainViewModel getMainViewModel() {
        return mainViewModel;
    }

    public LyricsViewModel getLyricsViewModel() {
        return lyricsViewModel;
    }

    public LoginRegisterViewModel getLoginRegisterViewModel() {
        return loginRegisterViewModel;
    }
}
