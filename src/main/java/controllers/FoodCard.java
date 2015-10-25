/* Developer: Mark Donile
** Date: 2015.10.24
** Configuration Version: 1.0.0
*/

package controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public class FoodCard extends HBox {

    //fields
    @FXML private Label foodNameLabel;
    @FXML private Button viewButton;
    @FXML private Button eatButton;

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

    public void handleViewButtonClick(){
        System.out.println("View Button clicked!");
    }

    public void handleEatButtonClick(){
        System.out.println("Eat Button clicked!");
    }

    public void setFoodName(String foodName){
        foodNameLabel.setText(foodName);
    }
}
