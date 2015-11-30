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


public class FoodScreen extends VBox implements SessionControl {

    private SessionManager sessionManager;
    private FoodData foodData = new FoodDataImpl();
    private HashMap<String, Food> foodMap = new HashMap<>();

    @FXML
    private ListView<String> foodListView;
    @FXML
    private Pane foodPane;

    public FoodScreen(){
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/views/food_screen.fxml"));
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
        FoodScreenCard foodScreenCard = new FoodScreenCard(food);
        foodScreenCard.setSessionManager(sessionManager);
        if(!foodPane.getChildren().isEmpty()){
            foodPane.getChildren().remove(0);
        }
        foodPane.getChildren().add(0, foodScreenCard);
    }

    @FXML
    public void handleDeleteButton(ActionEvent event){
        if(foodListView.getSelectionModel().getSelectedItem() != null){
            Food selectedFood = foodMap.get(foodListView.getSelectionModel().getSelectedItem());
            foodData.deleteFood(selectedFood.getNdbno());
            System.out.println(selectedFood.getName()+" deleted.");
            setFoodListView();
            foodPane.getChildren().remove(0);
        }else{
            System.out.println("Nothing selected");
        }
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
    public void setSessionManager(SessionManager sessionManager) {
        this.sessionManager = sessionManager;
        System.out.println(sessionManager.getCurrentDay().getDate());
    }
}