/* Developer: Mark Donile
** Date: 2015.11.01
** Configuration Version: 1.0.0
*/

package controllers;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import models.Food;
import util.database.FoodData;
import util.database.FoodDataImpl;

public class FoodDetailSubScreen extends VBox{
    FoodData foodData = new FoodDataImpl();
    //fields
    private Food food;
    @FXML private Label foodNameLabel;
    @FXML private Button viewButton;
    @FXML private Label kCalMeasureLabel;
    @FXML private Label measureValueLabel;
    @FXML private Button saveButton;

    //constructor(s)
    public FoodDetailSubScreen(Food food){
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/views/food_card.fxml"));
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

    //TODO Phil, can you explain this method?
    @FXML
    public void initialize(){
        System.out.println("FoodDetailSubScreen initialized");

        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                foodNameLabel.setText(food.getName());
            }
        });
    }

    @FXML
    public void handleSaveButton(ActionEvent event){
        foodData.saveFood(food);
    }

    public void setFoodName(){
        foodNameLabel.setText(food.getName());
    }

    public void setFoodName(String foodName){
        foodNameLabel.setText(foodName);
    }

    public void setkCalMeasure(String kCalMeasure){
        kCalMeasureLabel.setText(kCalMeasure);
    }

    public void setKCalMeasure(){
        kCalMeasureLabel.setText(food.getKCalMeasure());
    }

    public void setMeasureValue(String measure){
        measureValueLabel.setText(measure);
    }

    public void setMeasureValue(){
        measureValueLabel.setText(food.getMeasure());
    }

}
