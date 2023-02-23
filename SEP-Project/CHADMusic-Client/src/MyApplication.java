import javafx.application.Application;
import javafx.stage.Stage;
import model.MainModel;
import model.MainModelManager;
import view.ViewHandler;
import viewmodel.ViewModelFactory;

public class MyApplication extends Application
{
  public void start(Stage primaryStage)
  {
    try {
      primaryStage.setResizable(true);
      MainModel model = new MainModelManager();
      ViewModelFactory viewModelFactory = new ViewModelFactory(model);
      ViewHandler view = new ViewHandler(viewModelFactory);
      view.start(primaryStage);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
