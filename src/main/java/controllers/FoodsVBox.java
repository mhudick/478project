/* Developer: Mark Donile
** Date: 2015.10.31
** Configuration Version: 1.0.0
*/

package controllers;

import models.Food;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.VBox;

public class FoodsVBox extends VBox implements ManagedScreen{

    //fields
    private ScreenManager screenManager;

    public FoodsVBox(){
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/views/foods.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try{
            fxmlLoader.load();
        }
        catch(Exception e){
            System.out.println(e.toString());
        }
    }

    /*
    public void addFoods(){
        //this method was created for testing
        getChildren().add(new FoodCard());
    }
    */

    /*
    public void addFoods(Food[] foodArray){
        removeFoods();
        for(Food food : foodArray){
            FoodCard foodCard = new FoodCard();
            foodCard.setFoodName(food.getName());
            getChildren().add(new FoodCard());
        }
    }
    */

    public void removeFoods(){
        //TODO clear all food cards from the FoodsVBox
    }

    public void setScreenManager(ScreenManager screenManager){
        this.screenManager = screenManager;
    }

}