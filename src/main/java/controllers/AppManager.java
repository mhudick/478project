package controllers;

/* Developer: Mark Donile
** Date: 2015.10.31
** Configuration Version: 1.0.0
*/

/**
 * This Class is in charge of managing the screens during the login process.
 * When a user is selected and logs in, the SessionManager's currentUser
 * becomes set. It is then able to be retrieved by the HomeScreen Class.
 */

import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.layout.StackPane;
import javafx.fxml.FXMLLoader;
import java.util.HashMap;

public class AppManager extends StackPane{

    //HashMap to keep track of screens.
    private HashMap<Screen, Node> screens = new HashMap<>();
    //Reference for previous screen.
    private Node previousScreen;

    /*
    * Once a user is selected it is set to the session
    * manager and passed to the home screen.
    */
    private SessionManager sessionManager = new SessionManager();

    public AppManager(){
        super();
    }

    //methods
    public void addScreen(Screen screen, Node node){
        screens.put(screen, node);
    }

    public boolean loadScreen(Screen screen, String resourcePath){
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(resourcePath));
            Parent loadedScreen = (Parent) fxmlLoader.load();
            AppControl loadedScreenController = fxmlLoader.getController();
            loadedScreenController.setAppManager(this);
            addScreen(screen, loadedScreen);
            return true;
        }
        catch(Exception exception){
            System.out.println(exception.getMessage());
            return false;
        }
    }

    public void unloadScreen(Screen screen){
        screens.remove(screen);
    }

    public boolean show(Screen screen){
        if(screens.get(screen) != null){
            //screen was previously loaded and found in screens HashMap
            if(!getChildren().isEmpty()){
                //if a screen is presently shown
                setPreviousScreen(getChildren().remove(0)); //remove current screen and set previousScreen
            }
            //show new screen
            getChildren().add(0, screens.get(screen));
            return true;
        }
        else{
            System.out.println(screen.toString() + " was not found in AppManager screens HashMap.\n");
            return false;
        }
    }

    public void showPreviousScreen(){
        getChildren().remove(0);
        getChildren().add(0, getPreviousScreen());
    }

    public void setPreviousScreen(Node previousScreen){
        this.previousScreen = previousScreen;
    }

    public Node getPreviousScreen(){
        return previousScreen;
    }

    public SessionManager getSessionManager(){
        return sessionManager;
    }
}
