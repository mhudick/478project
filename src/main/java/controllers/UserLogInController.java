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

public class UserLogInController implements ManagedScreen, UserControl{

    //fields

    //private List userList;
    private ScreenManager screenManager;
    private UserManager userManager;
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
        System.out.println(userData.getAllUsers().get(userListView.getSelectionModel().getSelectedItem()));
        int userID = userData.getAllUsers().get(userListView.getSelectionModel().getSelectedItem());
        User user = userData.getUser(userID);
        System.out.println(user.getName());


        if(screenManager.hasScreen(Screen.HOME)){
            screenManager.unloadScreen(Screen.HOME);
            screenManager.loadScreen(Screen.HOME, Screen.HOME.getResourcePath());
        }

        screenManager.show(Screen.HOME);
    }

    public void setScreenManager(ScreenManager screenManager){
        this.screenManager = screenManager;
    }

    @Override
    public void setUserManager(UserManager userManager) {
        this.userManager = userManager;
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
