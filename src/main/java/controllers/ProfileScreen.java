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
import javafx.scene.control.Label;
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
    private Label messageLabel;

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

    /**
     * User may edit their profile data
     * (Requirement 2.2.0)
     */
    @FXML
    public void handleSaveButton(ActionEvent event){
        if(!nameTextField.getText().equals("") && !startWeightTextField.getText().equals("") &&
                !goalWeightTextField.getText().equals("") && !calLimitTextField.getText().equals("")){

            /**
             * User should be able to set their name
             * (Requirement 2.2.1)
             */
            sessionManager.getUser().setName(nameTextField.getText());
            /**
             * User should be able to set their starting weight
             * (Requirement 2.2.3)
             */
            sessionManager.getUser().setWeightStart(Double.parseDouble(startWeightTextField.getText()));
            /**
             * User should be able to set their goal weight
             * (Requirement 2.2.4)
             */
            sessionManager.getUser().setWeightGoal(Double.parseDouble(goalWeightTextField.getText()));
            /**
             * User should be able to set their daily calorie allowance
             * (Requirement 2.2.5)
             */
            sessionManager.getUser().setDailyCalorieLimit(Integer.parseInt(calLimitTextField.getText()));
            userData.saveUser(sessionManager.getUser());
            messageLabel.setText("");
            homeScreen.getMenuChoiceBox().setValue("Home");
        }else{
            //print message to user
            messageLabel.setText("Please fill out all fields.");
        }
    }

    @FXML
    public void handleCancelButton(ActionEvent event){
        messageLabel.setText("");
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
