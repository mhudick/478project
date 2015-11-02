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

public class UserLogInController implements ManagedScreen {

    //fields
    private User user;
    //private List userList;
    private ScreenManager screenManager;
    @FXML private ListView<User> userListView;
    @FXML private Button createUserButton;
    @FXML private Button selectUserButton;
    //private UserData userData = new UserData();

    //methods
    public void handleCreateUserButton(ActionEvent actionEvent){
        System.out.println("Create User button clicked!");
        screenManager.show(Screen.CREATE_USER);
    }

    public void handleSelectUserButton(ActionEvent actionEvent){
        System.out.println("Select button clicked!");
        if(screenManager.hasScreen(Screen.HOME)){
            screenManager.unloadScreen(Screen.HOME);
            screenManager.loadScreen(Screen.HOME, Screen.HOME.getResourcePath());
        }
        screenManager.show(Screen.HOME);
    }

    public void setScreenManager(ScreenManager screenManager){
        this.screenManager = screenManager;
    }

    public void loadUserListView(){
        //TODO UserData provide getUserDataArrayList() method?
        /*
        List<User> userArrayList = new ArrayList<>();
        HashMap userDataHashMap = userData.getAllUsers();
        Iterator iterator = userDataHashMap.entrySet().iterator();
        while(iterator.hasNext()){
            userArrayList.add((User) iterator.next());
        }
        ObservableList<User> userObsvList = FXCollections.observableArrayList(userArrayList);
        userListView = new ListView<User>(userArrayList);
        */
    }

}
