package controllers;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import models.Food;
import util.NumFieldFx;


/**
 * Created by Phil on 11/24/2015.
 */
public class FoodDataSubScreen extends VBox implements UserControl{

    UserManager userManager;

    Food food;

    @FXML
    Label nameLabel, calLabel;
    @FXML
    NumFieldFx gramTextField;


    public FoodDataSubScreen(Food food){
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/views/food_data_card.fxml"));
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
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                System.out.println("Run later");
                nameLabel.setText(food.getName());
            }
        });
        gramTextField.textProperty().addListener((observable, oldValue, newValue) -> {
            System.out.println("textfield changed from " + oldValue + " to " + newValue);
            calLabel.setText(String.valueOf(calculateCalories()));
        });
    }

    @FXML
    public void handleEatButton(ActionEvent event){
        System.out.println("Eat Button Clicked.");
        userManager.addCaloriesToDay(Integer.parseInt(calLabel.getText()));
    }

    public int calculateCalories(){
        System.out.println(food.getkCal());
        double answer = 0;
        if(!gramTextField.getText().equalsIgnoreCase("")){
            answer = ((food.getkCal()/100)*Integer.parseInt(gramTextField.getText()));
        }
        return (int) Math.round(answer);
    }

    @Override
    public void setUserManager(UserManager userManager) {
        this.userManager = userManager;
        System.out.println(userManager.getCurrentDay().toString());
    }
}
