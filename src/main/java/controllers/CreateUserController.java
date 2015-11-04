/* Developer: Mark Donile
** Date: 2015.10.31
** Configuration Version: 1.0.0
*/

package controllers;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.fxml.FXML;
import models.User;
import util.database.UserData;
import util.database.UserDataImpl;

public class CreateUserController implements ManagedScreen{
    private UserData userData = new UserDataImpl();

    //fields
    private ScreenManager screenManager;
    @FXML private TextField nameTextField;
    @FXML private TextField ageTextField;
    @FXML private Button createButton;
    @FXML private Button backButton;

    //methods
    public void handleCreateButton(ActionEvent actionEvent){
        System.out.println("Create button clicked!");
        User user = new User();
        user.setName(nameTextField.getText());
        user.setAge(ageTextField.getText());
        userData.saveUser(user);
        screenManager.unloadScreen(Screen.USER_LOG_IN);
        screenManager.loadScreen(Screen.USER_LOG_IN, Screen.USER_LOG_IN.getResourcePath());
        screenManager.show(Screen.USER_LOG_IN);
    }

    public void handleBackButton(ActionEvent actionEvent){
        System.out.println("Back button clicked!");
        screenManager.show(Screen.USER_LOG_IN);
    }

    public void setScreenManager(ScreenManager screenManager){
        this.screenManager = screenManager;
    }
}
