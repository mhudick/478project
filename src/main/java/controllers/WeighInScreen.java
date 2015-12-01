package controllers;

/* Developer: Philip Churchill
** Date: 2015.11.01
** Configuration Version: 1.0.0
*/

/**
 * This is the controller for managing the user's weigh-ins. It presents the user with the date
 * and a textField to enter the user weight for the weigh-in.
 * Once the weigh-in button is clicked the weigh-in data is saved to the database.
 */

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import util.NumFieldFx;
import util.database.UserData;
import util.database.UserDataImpl;
import util.database.WeighInData;
import util.database.WeighInImpl;

public class WeighInScreen extends VBox implements HomeControl, SessionControl {

    private HomeScreen homeScreen;
    private SessionManager sessionManager;
    private WeighInData weighInData = new WeighInImpl();
    private UserData userData = new UserDataImpl();

    @FXML
    private Label dateLabel;

    @FXML
    private NumFieldFx weightField;

    public WeighInScreen(){
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/views/weigh_in_screen.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try{
            fxmlLoader.load();
        }
        catch(Exception e){
            System.out.println(e.toString());
        }
    }

    public void setLabel(){
        dateLabel.setText(sessionManager.getCurrentDay().getDate());
    }

    /**
     * User should be able to update their current weight
     * (Requirement 2.2.0)
     */
    @FXML
    public void handleWeighInButton(ActionEvent event){
        weighInData.saveNewWeighIn(sessionManager.getUser().getUserId(), Integer.parseInt(weightField.getText()),sessionManager.getCurrentDay().getDate());
        sessionManager.getUser().setWeightCurrent(Integer.parseInt(weightField.getText()));
        userData.saveUser(sessionManager.getUser());
        homeScreen.getMenuChoiceBox().setValue("Home");
    }

    @FXML
    public void handleCancelButton(ActionEvent event){
        homeScreen.getMenuChoiceBox().setValue("Home");
    }

    @Override
    public void setHomeScreen(HomeScreen homeScreen) {
        this.homeScreen = homeScreen;
    }

    @Override
    public void setSessionManager(SessionManager sessionManager) {
        this.sessionManager = sessionManager;
    }
}
