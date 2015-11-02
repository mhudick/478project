/* Developer: Mark Donile
** Date: 2015.11.01
** Configuration Version: 1.0.0
*/

package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import models.Food;

public class FoodCard extends GridPane{

    //fields
    private Food food;
    @FXML private Label foodLabel;
    @FXML private Button viewButton;

    //constructor(s)
    public FoodCard(){
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/views/food_card.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try{
            fxmlLoader.load();
        }
        catch(Exception e){
            System.out.println(e.toString());
        }
    }

    public FoodCard(Food food){
        this();
        foodLabel.setText(food.getName());
    }

    public void handleViewButton(ActionEvent actionEvent){
        System.out.println(food.getName() + " view button was clicked!");
    }

}
