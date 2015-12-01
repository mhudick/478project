package controllers;

/* Developer: Mark Donile
** Date: 2015.10.31
** Configuration Version: 1.0.0
*/

/**
 * This Class is the controller for the login screen. It contains a listView
 * of users found in the local database. From here the user can create a new
 * profile, delete a user profile, and login.
 */

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import models.User;
import util.database.UserData;
import util.database.UserDataImpl;
import java.util.HashMap;

public class AppLoginScreen implements AppControl {

    //Is set to maintain a reference to the AppManager.
    private AppManager appManager;

    //Object for handling user data
    private UserData userData = new UserDataImpl();

    //Used for getting user Id from name
    private HashMap<String, User> userHashMap;

    //List of user names to add to Screen
    private ObservableList<String> nameList;

    @FXML
    private ListView<String> userListView;

    //Constructor
    public AppLoginScreen(){
        userHashMap = userData.getUserMap();
        nameList = userData.getUserNames();
    }

    @FXML
    public void initialize(){
        userListView.setItems(nameList);
    }

    //Calls appManager method for switching screens.
    @FXML
    public void handleCreateUserButton(ActionEvent actionEvent){
        System.out.println("Create User button clicked!");
        //Switches screen to userCreate screen
        appManager.show(Screen.CREATE_USER);
    }

    /*
    Selects a user from the list and passes it to the AppManager's
    sessionManager. Then loads the homeScreen.
     */
    @FXML
    public void handleSelectUserButton(ActionEvent actionEvent){
        if(userListView.getSelectionModel().getSelectedItem() != null){
            System.out.println("Select button clicked!");
            appManager.getSessionManager().setCurrentUser(userHashMap.get(getSelectedName()));
            appManager.loadScreen(Screen.HOME, Screen.HOME.getResourcePath());//Load Home Screen into appManager
            appManager.show(Screen.HOME);
        }else {
            System.out.println("Nothing selected");
        }
    }

    @FXML
    public void handleDeleteUserButton(ActionEvent event){
        if (userListView.getSelectionModel().getSelectedItem() != null){
            System.out.println("Deleting user: " + userHashMap.get(getSelectedName()).getName());
            userData.deleteUser(userHashMap.get(getSelectedName()).getUserId());
            userListView.setItems(userData.getUserNames());
        }else {
            System.out.println("Nothing selected");
        }
    }

    @Override
    public void setAppManager(AppManager appManager){
        this.appManager = appManager;
    }

    private String getSelectedName(){
       return userListView.getSelectionModel().getSelectedItem();
    }
}
