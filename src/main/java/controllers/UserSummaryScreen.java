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

public class UserSummaryScreen extends VBox implements UserControl,HomeScreenControl{

    UserManager userManager;
    HomeScreen homeScreen;
    @FXML
    private Label nameLabel,currentLabel, goalLabel,startLabel, dateLabel, limitLabel, availableLabel, totalLabel;

    public UserSummaryScreen(){
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/views/user_summary.fxml"));
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
    public void setUserManager(UserManager userManager) {
        this.userManager = userManager;
    }

    public void setLabels(){
        nameLabel.setText(userManager.getUser().getName());
        currentLabel.setText(String.valueOf(userManager.getUser().getWeightCurrent())+" lbs.");
        goalLabel.setText(String.valueOf(userManager.getUser().getWeightGoal())+" lbs.");
        startLabel.setText(String.valueOf(userManager.getUser().getWeightStart())+" lbs.");
        limitLabel.setText(String.valueOf(userManager.getUser().getDailyCalorieLimit()));
        availableLabel.setText(userManager.getCaloriesAvailable());
        totalLabel.setText(String.valueOf(userManager.getCurrentDay().getTotalCal()));
    }

    @Override
    public void sethomeScreen(HomeScreen homeScreen) {
        this.homeScreen = homeScreen;
    }
}
