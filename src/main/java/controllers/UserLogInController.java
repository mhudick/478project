/* Developer: Mark Donile
** Date: 2015.10.31
** Configuration Version: 1.0.0
*/

package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import models.User;
import util.database.UserData;
import util.database.UserDataImpl;

public class UserLogInController implements ManagedScreen{

    //fields

    //private List userList;
    private ScreenManager screenManager;
    UserData userData = new UserDataImpl();

    @FXML private ListView<String> userListView;
    @FXML private Button createUserButton;
    @FXML private Button selectUserButton;
    //private UserDataImpl userData = new UserDataImpl();

    //methods
    public void handleCreateUserButton(ActionEvent actionEvent){
        System.out.println("Create User button clicked!");
        screenManager.show(Screen.CREATE_USER);
    }

    public void handleSelectUserButton(ActionEvent actionEvent){
        System.out.println("Select button clicked!");

        int userID = userData.getAllUsers().get(userListView.getSelectionModel().getSelectedItem());
        User user = userData.getUser(userID);
        UserManager userManager = new UserManager();
        userManager.setUser(user);
        screenManager.setUserManager(userManager);
        if(screenManager.hasScreen(Screen.HOME)){
            screenManager.unloadScreen(Screen.HOME);
            screenManager.loadScreen(Screen.HOME, Screen.HOME.getResourcePath());
        }else{
            screenManager.loadScreen(Screen.HOME, Screen.HOME.getResourcePath());
        }
        screenManager.show(Screen.HOME);
    }

    public void setScreenManager(ScreenManager screenManager){
        this.screenManager = screenManager;
    }

    @FXML
    public void initialize(){
        loadUserListView();
    }
    public void loadUserListView(){
        //TODO UserDataImpl provide getUserDataArrayList() method?
        userListView.setItems(userData.getUserNames());
    }
}
