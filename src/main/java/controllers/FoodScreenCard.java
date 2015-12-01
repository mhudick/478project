package controllers;

/* Developer: Philip Churchill
** Date: 2015.11.05
** Configuration Version: 1.0.0
*/

/**
 * This class is the controller for the FoodCard that is presented when the
 * user selects a food object from the list. It will display the name and
 * provide a calorie conversion based on the amount in grams inputted by
 * the user. A button will allow the user to add the calorie amount to the
 * daily total.
 */

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import models.Food;
import util.NumFieldFx;

public class FoodScreenCard extends VBox implements SessionControl {

    private SessionManager sessionManager;
    private Food food;

    @FXML
    private Label nameLabel, calLabel, messageLabel;
    @FXML
    private NumFieldFx gramTextField;

    public FoodScreenCard(Food food){
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/views/food_screen_card.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try{
            fxmlLoader.load();
        }
        catch(Exception e){
            System.out.println(e.toString());
        }
        this.food = food;
    }

    @FXML
    public void initialize(){

        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                nameLabel.setText(food.getName());
            }
        });

        gramTextField.textProperty().addListener((observable, oldValue, newValue) -> {
            calLabel.setText(String.valueOf(calculateCalories()));
        });
    }

    /**
     * User should be able to keep track of food eaten.
     * (Requirement 2.6.0)
     */
    @FXML
    public void handleEatButton(ActionEvent event){
        System.out.println("Eat Button Clicked.");
        sessionManager.addCaloriesToDay(Integer.parseInt(calLabel.getText()));
        messageLabel.setText("Calories added to daily total.");
    }

    /**
     * User inputs mass and gets the kiloCalorie conversion value
     * (Requirement 3.6.0)
     */
    public int calculateCalories(){
        double answer = 0;
        if(!gramTextField.getText().equals("")){
            answer = ((food.getkCal()/100)*Integer.parseInt(gramTextField.getText()));
        }
        return (int) Math.round(answer);
    }

    @Override
    public void setSessionManager(SessionManager sessionManager) {
        this.sessionManager = sessionManager;
        System.out.println(sessionManager.getCurrentDay().toString());
    }
}
