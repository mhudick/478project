/* Developer: Mark Donile
** Date: 2015.10.31
** Configuration Version: 1.0.0
*/

package controllers;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import models.Food;
import util.database.FoodData;
import util.database.FoodDataImpl;

import java.util.HashMap;


public class FoodsVBox extends VBox implements UserControl{

    UserManager userManager;
    FoodData foodData = new FoodDataImpl();
    HashMap<String, Food> foodMap = new HashMap<>();
    @FXML
    ListView<String> foodListView;
    @FXML
    Pane foodPane;

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
        foodMap = foodData.getFoodMap();
    }

    @FXML
    public void handleMouseClick(MouseEvent arg0){
        System.out.println("clicked on " + foodListView.getSelectionModel().getSelectedItem().toString());
        Food food = foodMap.get(foodListView.getSelectionModel().getSelectedItem().toString());
        FoodDataSubScreen foodDataSubScreen = new FoodDataSubScreen(food);
        foodDataSubScreen.setUserManager(userManager);
        if(!foodPane.getChildren().isEmpty()){
            foodPane.getChildren().remove(0);
        }
        foodPane.getChildren().add(0, foodDataSubScreen);
    }

    public void setFoodListView(){
        foodListView.setItems(foodData.getFoodNameList());
        foodMap = foodData.getFoodMap();
    }

    @FXML
    public void initialize(){
        setFoodListView();
    }


    @Override
    public void setUserManager(UserManager userManager) {
        this.userManager = userManager;
        System.out.println(userManager.getCurrentDay().getDate());
    }
}