/* Developer: Mark Donile
** Date: 2015.10.31
** Configuration Version: 1.0.0
*/
package controllers;

/**
 * This Class will handle the user creation screen
 */

import javafx.event.ActionEvent;
import javafx.scene.control.TextField;
import javafx.fxml.FXML;
import models.User;
import util.database.UserData;
import util.database.UserDataImpl;

public class UserCreateScreen implements ManagedScreen{

    private UserData userData = new UserDataImpl();
    private ScreenManager screenManager;
    @FXML private TextField nameTextField;
    @FXML private TextField ageTextField;

    @FXML
    public void handleCreateButton(ActionEvent actionEvent){
        System.out.println("Create button clicked!");
        setUserData();
        screenManager.loadScreen(Screen.USER_LOG_IN, Screen.USER_LOG_IN.getResourcePath());
        screenManager.show(Screen.USER_LOG_IN);
    }
    @FXML
    public void handleBackButton(ActionEvent actionEvent){
        System.out.println("Back button clicked!");
        screenManager.show(Screen.USER_LOG_IN);
    }
    @Override
    public void setScreenManager(ScreenManager screenManager){
        this.screenManager = screenManager;
    }
    public void setUserData(){
        User user = new User();
        user.setName(nameTextField.getText());
        user.setAge(Integer.parseInt(ageTextField.getText()));
        userData.saveUser(user);
    }
}
