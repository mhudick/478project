package controllers;


import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.layout.StackPane;
import models.User;


import java.util.HashMap;

/**
 * Created by Philip on 10/27/2015.
 */
public class ScreenManager extends StackPane {

    private HashMap<String,Node> screens = new HashMap<>();

    private User user;
    public ScreenManager(){
        super();
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void addScreen(String name, Node screen){
        screens.put(name,screen);
    }

    public boolean loadScreen(String name, String resource) {
        try {
            FXMLLoader myLoader = new FXMLLoader(getClass().getResource(resource));
            Parent loadScreen = (Parent)myLoader.load();
            ScreenControl myScreenController = myLoader.getController();
            myScreenController.setScreenParent(this);
            myScreenController.setComponents();
            addScreen(name, loadScreen);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
    public boolean setScreen(final String name) {
        if (screens.get(name) != null) {   //screen loaded
            if (!getChildren().isEmpty()) {    //if there is more than one screen
                getChildren().remove(0);                    //remove the displayed screen
                getChildren().add(0, screens.get(name));     //add the screen
            } else {
                getChildren().add(screens.get(name));       //no one else been displayed, then just show
                System.out.println(screens.get(name));
            }
            return true;
        } else {
            System.out.println("screen hasn't been loaded!!! \n");
            return false;
        }
    }
    public boolean unloadScreen(String name) {
        if(screens.remove(name) == null) {
            System.out.println("Screen didn't exist");
            return false;
        } else {
            return true;
        }
    }
    public void reloadScreen(String name){
        unloadScreen(name);
        loadScreen(name,"/views/"+name+".fxml");
        setScreen(name);
    }
}
