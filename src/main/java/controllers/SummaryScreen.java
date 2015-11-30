/* Developer: Mark Donile
** Date: 2015.10.31
** Configuration Version: 1.0.0
*/

package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class SummaryScreen extends VBox implements SessionControl, HomeControl {

    private SessionManager sessionManager;
    private HomeScreen homeScreen;
    @FXML
    private Label nameLabel,currentLabel, goalLabel,startLabel, dateLabel, limitLabel, availableLabel, totalLabel;

    public SummaryScreen(){
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/views/summary_screen.fxml"));
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
    public void initialize(){

    }

    @FXML
    public void handleWeighButton(ActionEvent event){
        homeScreen.getMenuChoiceBox().setValue("Weigh-In");
    }

    @FXML
    public void handleMealButton(ActionEvent event){
        homeScreen.getMenuChoiceBox().setValue("Foods");
    }

    @FXML
    public void handleEditButton(ActionEvent event){
        homeScreen.getMenuChoiceBox().setValue("Edit Profile");
    }

    @Override
    public void setSessionManager(SessionManager sessionManager) {
        this.sessionManager = sessionManager;
    }

    public void setLabels(){
        nameLabel.setText(sessionManager.getUser().getName());
        currentLabel.setText(String.valueOf(sessionManager.getUser().getWeightCurrent())+" lbs.");
        goalLabel.setText(String.valueOf(sessionManager.getUser().getWeightGoal())+" lbs.");
        startLabel.setText(String.valueOf(sessionManager.getUser().getWeightStart())+" lbs.");
        limitLabel.setText(String.valueOf(sessionManager.getUser().getDailyCalorieLimit()));
        availableLabel.setText(sessionManager.getCaloriesAvailable());
        totalLabel.setText(String.valueOf(sessionManager.getCurrentDay().getTotalCal()));
        dateLabel.setText(sessionManager.getCurrentDay().getDate());
    }

    @Override
    public void setHomeScreen(HomeScreen homeScreen) {
        this.homeScreen = homeScreen;
    }
}
