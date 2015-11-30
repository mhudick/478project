/* Developer: Mark Donile
** Date: 2015.11.01
** Configuration Version: 1.0.0
*/

package controllers;

import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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
        System.out.println("SearchScreenCard initialized");

        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                nameLabel.setText(food.getName());
                calLabel.setText(String.valueOf((int) Math.round(food.getkCal())));
            }
        });
    }

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
