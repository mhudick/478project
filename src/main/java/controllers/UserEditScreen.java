package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import models.User;
import util.database.UserData;
import util.database.UserDataImpl;

/**
 * Created by Philip on 11/24/2015.
 */
public class UserEditScreen extends VBox implements UserControl, HomeScreenControl {

    UserManager userManager;
    HomeScreen  homeScreen;
    UserData userData = new UserDataImpl();


    @FXML
    TextField nameTextField, startTextField, limitTextField, goalTextField;

    public UserEditScreen(){
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/views/edit_screen.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);
        try{
            fxmlLoader.load();
        }
        catch(Exception e){
            System.out.println(e.toString());
        }
    }

    @FXML
    public void handleSaveButton(ActionEvent event){
        homeScreen.getMenuChoiceBox().setValue("Home");
    }

    @FXML
    public void handleCancelButton(ActionEvent event){
        homeScreen.getMenuChoiceBox().setValue("Home");
    }
    @Override
    public void sethomeScreen(HomeScreen homeScreen) {
        this.homeScreen=homeScreen;
    }

    @Override
    public void setUserManager(UserManager userManager) {
        this.userManager = userManager;
    }
}
