package view;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Region;

import java.util.HashMap;
import java.util.Map;

public abstract class ViewCreator {
    private Map<String,ViewController> controllers;
    public ViewCreator() {
        controllers = new HashMap<>();
    }

    public ViewController getViewController(String id) {
        ViewController controller = controllers.get(id);
        if(controller == null)
        {
            controller = loadFromFXML(id);
            System.out.println("Controller loaded: " + controller);
            System.out.println("Root: "+controller.getRoot());
            controllers.put(id,controller);
        }
        else
        {
            controller.reset();
        }
        System.out.println(controller +" : after the if statement");
        System.out.println(controller.getRoot() + " - this is the root");
        return controller;
    }

    private ViewController loadFromFXML(String file) {
        ViewController controller = null;
            try {
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource(file));
                Region root = loader.load();
                System.out.println(root + " - root");
                controller = loader.getController();
                initViewController(controller, root);

                System.out.println(controller.getRoot() + ": from load from fxml");
                if(controller == null){
                    throw new Exception("controller == null");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        return controller;
    }

    protected abstract void initViewController(ViewController controller, Region root);
}