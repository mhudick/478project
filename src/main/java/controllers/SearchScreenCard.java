package controllers;

/* Developer: Mark Donile
** Date: 2015.11.01
** Configuration Version: 1.0.0
*/

/**
 * This class acts as the controller that displays the food object details
 * provided by the SearchScreen. It will display the Food name and calories
 * per 100 grams. A save button will allow the user to save the food object
 * to the local database for a later reference.
 */

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import models.Food;
import util.database.FoodData;
import util.database.FoodDataImpl;

public class SearchScreenCard extends VBox{

    private FoodData foodData = new FoodDataImpl();
    //fields
    private Food food;
    @FXML
    private Label nameLabel, calLabel, messageLabel;

    //constructor(s)
    public SearchScreenCard(Food food){
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/views/search_screen_card.fxml"));
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
                calLabel.setText(String.valueOf((int) Math.round(food.getkCal())));
            }
        });
    }

    /**
     * Food retrieved from search can be saved to local database
     * (Requirement 6.4.0)
     */
    @FXML
    public void handleSaveButton(ActionEvent event){
        if(foodData.saveFood(food)){
            //Print to screen food saved
            messageLabel.setText("Food saved successfully.");
        }else{
            //Print to screen save failed.
            messageLabel.setText("Food could not be saved.");
        }
        System.out.println("Food Save Clicked");
    }
}
