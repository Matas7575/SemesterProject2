package view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;
import viewmodel.LoginRegisterViewModel;
import viewmodel.ViewModelFactory;

public class LoginRegisterViewController extends ViewController {
    @FXML
    private TextField loginUsernameField;
    @FXML
    private TextField loginPasswordField;
    @FXML
    private TextField emailField;
    @FXML
    private TextField registerUsernameField;
    @FXML
    private TextField registerPasswordField;
    @FXML
    private Label errorLabel;


    private Region root;
    private ViewHandler viewHandler;
    private ViewModelFactory viewModelFactory;
    private LoginRegisterViewModel loginRegisterViewModel;

    public LoginRegisterViewController() {
    }

    public void init(ViewHandler viewHandler, ViewModelFactory viewModelFactory, Region root) {
        this.viewHandler = viewHandler;
        this.viewModelFactory = viewModelFactory;
        this.root = root;
        System.out.println("Nickname: "+root);
        this.loginRegisterViewModel = viewModelFactory.getLoginRegisterViewModel();
        init();
    }

    @Override
    public Region getRoot() {
        return root;
    }

    @Override
    protected void init() {
        loginUsernameField.textProperty().bindBidirectional(loginRegisterViewModel.loginUsernameFieldProperty());
        loginPasswordField.textProperty().bindBidirectional(loginRegisterViewModel.loginPasswordFieldProperty());
        emailField.textProperty().bindBidirectional(loginRegisterViewModel.emailFieldProperty());
        registerPasswordField.textProperty().bindBidirectional(loginRegisterViewModel.registerPasswordFieldProperty());
        registerUsernameField.textProperty().bindBidirectional(loginRegisterViewModel.registerUsernameFieldProperty());
        errorLabel.textProperty().bind(loginRegisterViewModel.errorLabelProperty());
    }

    @Override
    public void reset() {

    }

    @FXML
    private void onEnterLogin() {
        loginPressed();
    }

    @FXML
    private void onEnterRegister() {
        registerPressed();
    }

    @FXML
    private void loginPressed(){
        loginRegisterViewModel.loginPressed();
        if(loginRegisterViewModel.isLoggedRegistered()) {
            viewHandler.openView("Chad_music_main_tab.fxml");
            viewModelFactory.getMainViewModel().setUserHeyProperty(loginUsernameField.getText());
        }

    }

    @FXML
    private void registerPressed(){
        loginRegisterViewModel.registerPressed();
        if(loginRegisterViewModel.isLoggedRegistered()) {
            viewHandler.openView("Chad_music_main_tab.fxml");
            viewModelFactory.getMainViewModel().setUserHeyProperty(registerUsernameField.getText());
        }
    }

}
