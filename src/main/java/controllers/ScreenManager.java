/* Developer: Mark Donile
** Date: 2015.10.31
** Configuration Version: 1.0.0
*/

package controllers;

import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.layout.StackPane;
import javafx.fxml.FXMLLoader;

import java.util.HashMap;

public class ScreenManager extends StackPane{

    //fields
    private HashMap<Screen, Node> screens = new HashMap<>();

    public ScreenManager(){
        super();
    }

    //methods
    public void addScreen(Screen screen, Node node){
        screens.put(screen, node);
    }

    public void removeScreen(Screen screen){
        screens.remove(screen);
    }

    public boolean loadScreen(Screen screen, String resourcePath){
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(resourcePath));
            Parent loadedScreen = (Parent) fxmlLoader.load();
            ManagedScreen loadedScreenController = (ManagedScreen) fxmlLoader.getController();
            loadedScreenController.setScreenManager(this);
            addScreen(screen, loadedScreen);
            return true;
        }
        catch(Exception exception){
            System.out.println(exception.getMessage());
            return false;
        }
    }

    public boolean show(Screen screen){
        if(screens.get(screen) != null){
            //screen was previously loaded and found in screens HashMap
            if(!getChildren().isEmpty()){
                //if a screen is presently shown
                getChildren().remove(0); //remove present screen
            }
            //show new screen
            getChildren().add(0, screens.get(screen));
            return true;
        }
        else{
            System.out.println(screen.toString() + " was not found in ScreenManager screens HashMap.\n");
            return false;
        }
    }

}