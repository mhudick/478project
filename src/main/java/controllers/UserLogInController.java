/* Developer: Mark Donile
** Date: 2015.10.31
** Configuration Version: 1.0.0
*/

package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import util.database.UserData;

public class UserLogInController implements ManagedScreen {

    //fields
    private ScreenManager screenManager;
    @FXML private ListView userListView;
    @FXML private Button createUserButton;
    @FXML private Button selectUserButton;
    private UserData userData = new UserData();

    //methods
    public void handleCreateUserButton(ActionEvent actionEvent){
        System.out.println("Create User button clicked!");
    }

    public void handleSelectUserButton(ActionEvent actionEvent){
        System.out.println("Select button clicked!");
    }

    public void setScreenManager(ScreenManager screenManager){
        this.screenManager = screenManager;
    }

    public void loadUserListView(){

    }
}
