/* Developer: Mark Donile
** Date: 2015.10.31
** Configuration Version: 1.0.0
*/

package controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import models.User;
import util.database.UserData;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;


public class UserLogInController implements ManagedScreen {

    //fields
    private ScreenManager screenManager;
    @FXML private ListView<User> userListView;
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
        List<User> userArrayList = new ArrayList<>();
        HashMap userDataHashMap = userData.getAllUsers();
        Iterator iterator = userDataHashMap.entrySet().iterator();
        while(iterator.hasNext()){
            userArrayList.add((User) iterator.next());
        }
        ObservableList<User> userObsvList = FXCollections.observableArrayList(userArrayList);
        userListView = new ListView<User>(userArrayList);
    }

}
