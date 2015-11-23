/* Developer: Mark Donile
** Date: 2015.10.31
** Configuration Version: 1.0.0
*/

package controllers;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import util.database.UserData;
import util.database.UserDataImpl;
import java.util.HashMap;

public class UserLoginScreen implements ManagedScreen{

    private ScreenManager screenManager;

    //Object for handling user data
    UserData userData = new UserDataImpl();

    //Object that will manage the logged in user
    UserManager userManager = new UserManager();

    //Used for getting user Id from name
    private HashMap<String,Integer> userHashMap;

    //List of user names to add to Screen
    private ObservableList<String> nameList;

    //Constructor
    public UserLoginScreen(){
        userHashMap = userData.getUserMap();
        nameList = userData.getUserNames();
    }

    @FXML private ListView<String> userListView;

    @FXML
    public void initialize(){
        userListView.setItems(nameList);
    }
    @FXML
    public void handleCreateUserButton(ActionEvent actionEvent){
        System.out.println("Create User button clicked!");
        //Switches screen to userCreate screen
        screenManager.show(Screen.CREATE_USER);
    }
    @FXML
    public void handleSelectUserButton(ActionEvent actionEvent){
        System.out.println("Select button clicked!");
        int userId = userHashMap.get(getSelectedName());//Get user id related to selected name
        userManager.setUser(userData.getUser(userId));//Sets the current user in the userManager
        screenManager.setUserManager(userManager);//Sets the userManager of the screenManager
        screenManager.loadScreen(Screen.HOME, Screen.HOME.getResourcePath());//Load Home Screen into screenManager
        screenManager.show(Screen.HOME);
    }
    @Override
    public void setScreenManager(ScreenManager screenManager){
        this.screenManager = screenManager;
    }

    public String getSelectedName(){
       return userListView.getSelectionModel().getSelectedItem();
    }
}
