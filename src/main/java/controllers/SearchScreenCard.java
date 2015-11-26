/* Developer: Mark Donile
** Date: 2015.11.01
** Configuration Version: 1.0.0
*/

package controllers;

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
    private Label nameLabel, calLabel;

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
        foodData.saveFood(food);
        System.out.println("Food Saved");
    }
}
