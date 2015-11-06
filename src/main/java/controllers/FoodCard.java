/* Developer: Mark Donile
** Date: 2015.11.01
** Configuration Version: 1.0.0
*/

package controllers;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import models.Food;

public class FoodCard extends VBox{

    //fields
    private Food food;
    @FXML private Label nameLabel;
    @FXML private Button viewButton;

    //constructor(s)
    public FoodCard(Food food){
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
    @FXML
    public void initialize(){
        System.out.println("FoodCard initialized");

        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                nameLabel.setText(food.getName());
            }
        });
    }
}
