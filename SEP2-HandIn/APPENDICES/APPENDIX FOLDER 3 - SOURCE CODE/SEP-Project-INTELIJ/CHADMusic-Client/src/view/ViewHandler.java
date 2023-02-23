package view;

import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Region;
import javafx.stage.Stage;
import viewmodel.ViewModelFactory;

public class ViewHandler extends ViewCreator{
  private Scene currentScene;
  private Stage primaryStage;
  private ViewModelFactory viewModelFactory;

  public ViewHandler(ViewModelFactory viewModelFactory) {
    this.viewModelFactory = viewModelFactory;
  }

  public void start(Stage primaryStage) {
    this.primaryStage = primaryStage;
    this.primaryStage.getIcons().add(new Image("Logo.png"));
    this.primaryStage.setTitle("CHADMusic");
    this.currentScene = new Scene(new Region());
    openView("Chad_music_login_window.fxml");
  }

  public void openView(String id) {
    Region root = getViewController(id).getRoot();
    System.out.println(root);

    currentScene.setRoot(root);
    String title = "";
    if(root.getUserData() != null){
      title += root.getUserData();
    }
    primaryStage.setTitle(title);
    primaryStage.setScene(currentScene);
    primaryStage.setWidth(root.getPrefWidth());
    primaryStage.setHeight(root.getPrefHeight());
    primaryStage.show();
  }

  @Override protected void initViewController(ViewController controller, Region root) {
    controller.init(this, viewModelFactory, root);
  }
}
