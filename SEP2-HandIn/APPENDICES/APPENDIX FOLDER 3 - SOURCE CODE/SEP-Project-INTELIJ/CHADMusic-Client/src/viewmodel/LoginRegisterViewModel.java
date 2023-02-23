package viewmodel;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import model.*;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class LoginRegisterViewModel implements PropertyChangeListener {
    private StringProperty loginUsernameFieldProperty;
    private StringProperty loginPasswordFieldProperty;
    private StringProperty registerUsernameFieldProperty;
    private StringProperty registerPasswordFieldProperty;
    private StringProperty emailFieldProperty;
    private StringProperty errorLabelProperty;
    private MainModel model;

    public LoginRegisterViewModel(MainModel model) {
        this.model = model;
        loginUsernameFieldProperty = new SimpleStringProperty();
        loginPasswordFieldProperty = new SimpleStringProperty();
        registerUsernameFieldProperty = new SimpleStringProperty();
        registerPasswordFieldProperty = new SimpleStringProperty();
        emailFieldProperty = new SimpleStringProperty();
        errorLabelProperty = new SimpleStringProperty();
    }

    public boolean isLoggedRegistered() {
        return model.isLoggedIn();
    }

    public StringProperty loginUsernameFieldProperty() {
        return loginUsernameFieldProperty;
    }

    public StringProperty loginPasswordFieldProperty() {
        return loginPasswordFieldProperty;
    }

    public StringProperty registerUsernameFieldProperty() {
        return registerUsernameFieldProperty;
    }

    public StringProperty registerPasswordFieldProperty() {
        return registerPasswordFieldProperty;
    }

    public StringProperty emailFieldProperty() {
        return emailFieldProperty;
    }

    public StringProperty errorLabelProperty() {
        return errorLabelProperty;
    }

    public void loginPressed() {
        model.logIn(new Username(loginUsernameFieldProperty.get()), new Password(loginPasswordFieldProperty.get()));
        if(!model.isLoggedIn())
            errorLabelProperty.set("Incorrect credentials or nonexistent user!");
    }

    public void registerPressed() {
        model.register(new Username(registerUsernameFieldProperty.get()), new Email(emailFieldProperty.get()), new Password(registerPasswordFieldProperty.get()));
        if(!model.isLoggedIn())
            errorLabelProperty.set("There is already a user registered with those creditals!");
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        switch (evt.getPropertyName()) {
            case "error" -> {
                errorLabelProperty.set(String.valueOf(evt.getNewValue()));
            }
        }
    }
}
