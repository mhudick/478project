package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import util.database.UserData;
import util.database.UserDataImpl;

/**
 * Created by Philip on 11/24/2015.
 */
public class ProfileScreen extends VBox implements SessionControl, HomeControl {

    private SessionManager sessionManager;
    private HomeScreen  homeScreen;
    private UserData userData = new UserDataImpl();


    @FXML
    TextField nameTextField, startTextField, limitTextField, goalTextField;

    public ProfileScreen(){
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/views/profile_screen.fxml"));
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
    public void setHomeScreen(HomeScreen homeScreen) {
        this.homeScreen=homeScreen;
    }

    @Override
    public void setSessionManager(SessionManager sessionManager) {
        this.sessionManager = sessionManager;
    }
}
