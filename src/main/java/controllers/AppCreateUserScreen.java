/** Developer: Mark Donile
*   Date: 2015.10.31
*   Configuration Version: 1.0.0
*/

/*
This class is the controller for the create user screen. It contains fields
for the user to fill out. Once complete the user can either click button to
create a new user or cancel to go back to login screen.
 */
package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import models.User;
import util.NumFieldFx;
import util.database.UserData;
import util.database.UserDataImpl;

public class AppCreateUserScreen implements AppControl {

    private UserData userData = new UserDataImpl();//User data access object
    private AppManager appManager;//Reference to AppManager

    @FXML
    private NumFieldFx goalTextField, currentTextField;

    @FXML
    private TextField nameTextField;

    @FXML
    public void handleCreateButton(ActionEvent actionEvent){
        System.out.println("Create button clicked!");
        saveNewUser();
        appManager.loadScreen(Screen.USER_LOG_IN, Screen.USER_LOG_IN.getResourcePath());
        appManager.show(Screen.USER_LOG_IN);
    }
    @FXML
    public void handleBackButton(ActionEvent actionEvent){
        System.out.println("Back button clicked!");
        appManager.show(Screen.USER_LOG_IN);
    }

    public void saveNewUser(){
        User user = new User();
        user.setName(nameTextField.getText());
        user.setWeightGoal(Double.parseDouble(goalTextField.getText()));
        user.setWeightCurrent(Double.parseDouble(currentTextField.getText()));
        user.setWeightStart(user.getWeightCurrent());
        userData.saveNewUser(user);
        clearTextFields();
    }
    public void clearTextFields(){
        nameTextField.setText("");
        goalTextField.setText("");
        currentTextField.setText("");
    }
    @Override
    public void setAppManager(AppManager appManager){
        this.appManager = appManager;
    }
}
