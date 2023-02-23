package viewmodel;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
//this test class requires the server running
class LoginRegisterViewModelTest {

    private LoginRegisterViewModel viewModel;
    private MainModel model;

    @BeforeEach
    void setup()
    {
        Username username = new Username("Dummy");
        Password password = new Password("no");
        Email email = new Email("Via@gmail.com");
        model = new MainModelManager();
        viewModel = new LoginRegisterViewModel(model);
        model.register(username,email,password);
    }
    @Test
    public void RegisterUserSuccessful()
    {
        //arrange
        StringProperty registerUsernameFieldProperty = new SimpleStringProperty();
        StringProperty registerPasswordFieldProperty = new SimpleStringProperty();
        StringProperty emailFieldProperty = new SimpleStringProperty();
        StringProperty errorLabel = new SimpleStringProperty();
        viewModel.errorLabelProperty().bindBidirectional(errorLabel);
        viewModel.registerPasswordFieldProperty().bindBidirectional(registerPasswordFieldProperty);
        viewModel.registerUsernameFieldProperty().bindBidirectional(registerUsernameFieldProperty);
        viewModel.emailFieldProperty().bindBidirectional(emailFieldProperty);

        //act

        registerUsernameFieldProperty.setValue("boomer");
        registerPasswordFieldProperty.setValue("yes");
        emailFieldProperty.setValue("ohGee@gmail.com");
        viewModel.registerPressed();

        //assert

        assertEquals("StringProperty [value: null]",""+errorLabel);
    }
    @Test
    public void RegisterUserUnsuccessful()
    {
        //arrange
        StringProperty registerUsernameFieldProperty = new SimpleStringProperty();
        StringProperty registerPasswordFieldProperty = new SimpleStringProperty();
        StringProperty emailFieldProperty = new SimpleStringProperty();
        StringProperty errorLabel = new SimpleStringProperty();
        viewModel.errorLabelProperty().bindBidirectional(errorLabel);
        viewModel.registerPasswordFieldProperty().bindBidirectional(registerPasswordFieldProperty);
        viewModel.registerUsernameFieldProperty().bindBidirectional(registerUsernameFieldProperty);
        viewModel.emailFieldProperty().bindBidirectional(emailFieldProperty);

        //act
        model.isLoggedIn();
        registerUsernameFieldProperty.setValue("Dummy");
        registerPasswordFieldProperty.setValue("no");
        emailFieldProperty.setValue("Via@gmail.com");
        viewModel.registerPressed();


        //assert

        assertEquals("StringProperty [value: There is already a user registered with those creditals!]",""+errorLabel);
    }
    @Test
    public void LoginUserSuccessful()
    {
        //arrange
        StringProperty loginUsernameFieldProperty = new SimpleStringProperty();
        StringProperty loginPasswordFieldProperty = new SimpleStringProperty();
        StringProperty errorLabel = new SimpleStringProperty();
        viewModel.loginUsernameFieldProperty().bindBidirectional(loginUsernameFieldProperty);
        viewModel.loginPasswordFieldProperty().bindBidirectional(loginPasswordFieldProperty);
        viewModel.errorLabelProperty().bindBidirectional(errorLabel);

        //act
        loginUsernameFieldProperty.setValue("Admin");
        loginPasswordFieldProperty.setValue("admin");
        viewModel.loginPressed();

        //assert
        assertEquals("StringProperty [value: null]",""+errorLabel);
    }

    @Test
    public void LoginUserUnsuccessful()
    {
        //arrange
        StringProperty loginUsernameFieldProperty = new SimpleStringProperty();
        StringProperty loginPasswordFieldProperty = new SimpleStringProperty();
        StringProperty errorLabel = new SimpleStringProperty();
        viewModel.loginUsernameFieldProperty().bindBidirectional(loginUsernameFieldProperty);
        viewModel.loginPasswordFieldProperty().bindBidirectional(loginPasswordFieldProperty);
        viewModel.errorLabelProperty().bindBidirectional(errorLabel);

        //act
        loginUsernameFieldProperty.setValue("noExist");
        loginPasswordFieldProperty.setValue("noPassword");
        viewModel.loginPressed();

        //assert
        assertEquals("StringProperty [value: Incorrect credentials or nonexistent user!]",""+errorLabel);
    }
}