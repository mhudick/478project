package controllers;

/* Developer: Philip Churchill
** Date: 2015.1.15
** Configuration Version: 1.0.0
*/

/**
 * This Class is the controller for the profile screen. It allows the user to view and edit
 * information stored in the user class. The user will be able to modify starting weight,
 * goal weight, calorie limit, and name.
 */

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import util.NumFieldFx;
import util.database.UserData;
import util.database.UserDataImpl;

public class ProfileScreen extends VBox implements SessionControl, HomeControl {

    private SessionManager sessionManager;
    private HomeScreen  homeScreen;
    private UserData userData = new UserDataImpl();


    @FXML
    private TextField nameTextField;

    @FXML
    private NumFieldFx startWeightTextField, calLimitTextField, goalWeightTextField;

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
        sessionManager.getUser().setName(nameTextField.getText());
        sessionManager.getUser().setWeightStart(Double.parseDouble(startWeightTextField.getText()));
        sessionManager.getUser().setWeightGoal(Double.parseDouble(goalWeightTextField.getText()));
        sessionManager.getUser().setDailyCalorieLimit(Integer.parseInt(calLimitTextField.getText()));
        userData.saveUser(sessionManager.getUser());
        homeScreen.getMenuChoiceBox().setValue("Home");
    }

    @FXML
    public void handleCancelButton(ActionEvent event){
        homeScreen.getMenuChoiceBox().setValue("Home");
    }

    public void setTextFields(){
        nameTextField.setText(sessionManager.getUser().getName());
        startWeightTextField.setText(String.valueOf(sessionManager.getUser().getWeightStart()));
        goalWeightTextField.setText(String.valueOf(sessionManager.getUser().getWeightGoal()));
        calLimitTextField.setText(String.valueOf(sessionManager.getUser().getDailyCalorieLimit()));
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
