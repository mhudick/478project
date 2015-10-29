/* Developer: Mark Donile
** Date: 2015.10.18
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
import util.database.DataAccess;
import util.database.DataAccessImpl;

import java.util.*;

public class UserLogin implements ScreenControl{

    //Will hold reference to parent screenController
    ScreenManager myController;

    //Interface for local database
    DataAccess dataAccess = new DataAccessImpl();

    //HashMap that will hold Users from local database
    HashMap<String, User> userList = new HashMap<>();

    //fxml injections
    @FXML ListView<String> userListView;
    @FXML Button newUserButton, selectUserButton;

    //Methods to retrieve Hashmap of Users from local database and displays in list view
    public void setupUserList(){
        userListView.setPrefSize(200,480);
        userList = dataAccess.getAllUser();
        Iterator iterator = userList.entrySet().iterator();
        List<String> nameList = new ArrayList<>();
        while (iterator.hasNext()){
            Map.Entry pair = (Map.Entry)iterator.next();
            nameList.add(pair.getKey().toString());
        }
        ObservableList<String> data = FXCollections.observableArrayList(nameList);
        System.out.println(data.toString());
        userListView.setItems(data);
    }
    //Logs user into application
    public void selectUserButton(ActionEvent event){
        //Sets mainControllers User and loads screens
        myController.setUser(userList.get(userListView.getSelectionModel().getSelectedItem()));
        myController.loadScreen("user_summary","/views/user_summary.fxml");
        myController.setScreen("user_summary");
    }
    //Switches to screen to create a user
    public void handleNewButton(ActionEvent event){
        myController.setScreen("new_user");
    }

    @FXML
     public void initialize(){
        System.out.println("initialize");
    }

    @Override
    public void setScreenParent(ScreenManager screenParent) {
        myController = screenParent;
        System.out.println("setScreenParent");
    }

    @Override
    public void setComponents() {
        setupUserList();
        System.out.println("setComponents");
    }
}
