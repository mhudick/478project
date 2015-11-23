/* Developer: Mark Donile
** Date: 2015.10.31
** Configuration Version: 1.0.0
*/

package controllers;

import models.Food;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.VBox;

import java.util.ArrayList;

public class FoodsVBox extends VBox implements ManagedScreen{

    //fields
    private ScreenManager screenManager;
    private ArrayList<Food> foodArrayList = new ArrayList<>();

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

    public void addFoods(Food[] foodArray){
        removeFoods();
        for(Food food : foodArray){
            FoodDetailSubScreen foodCard = new FoodDetailSubScreen(food);
            foodCard.setFoodName(food.getName());
            foodCard.setkCalMeasure(food.getKCalMeasure());
            foodCard.setMeasureValue(food.getMeasure());
            getChildren().add(foodCard);
        }
    }

    public void removeFoods(){
        this.getChildren().clear();
        foodArrayList.clear();
    }

    public void setScreenManager(ScreenManager screenManager){
        this.screenManager = screenManager;
    }

    public void setFoodArrayList(){

    }

}