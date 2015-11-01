/* Developer: Mark Donile
** Date: 2015.10.31
** Configuration Version: 1.0.0
*/

package controllers;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.fxml.FXML;

public class CreateUserController implements ManagedScreen{

    //fields
    private ScreenManager screenManager;
    @FXML private TextField nameTextField;
    @FXML private TextField ageTextField;
    @FXML private Button createButton;
    @FXML private Button backButton;

    //methods
    public void handleCreateButton(ActionEvent actionEvent){
        System.out.println("Create button clicked!");
        screenManager.show(Screen.USER_LOG_IN);
    }

    public void handleBackButton(ActionEvent actionEvent){
        System.out.println("Back button clicked!");
        screenManager.showPreviousScreen();
    }

    public void setScreenManager(ScreenManager screenManager){
        this.screenManager = screenManager;
    }
}
