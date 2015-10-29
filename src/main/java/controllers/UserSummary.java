package controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Philip on 10/28/2015.
 */
public class UserSummary implements ScreenControl{

    ScreenManager myController = new ScreenManager();

    private static final String CHANGE_USER = "Change User";
    private static final String DAILY_TRACKER = "Daily Tracker";
    private static final String EXERCISE = "Exercise";
    private static final String FOODS = "Foods";
    private static final String HOME = "Home";
    private static final String RECIPES = "Recipes";
    private static final String WEIGH_IN = "Weigh-in";

    @FXML Label name_label,age_label;
    @FXML ChoiceBox<String> menuChoiceBox;

    @FXML
    public void initialize(){
        System.out.println("initialize");

    }

    @FXML
    public void handleSearchButton(ActionEvent event){
        System.out.println("Pressed");
    }

    @FXML
    public void handleRecipeButton(ActionEvent event){
        System.out.println("Pressed");
    }

    @Override
    public void setScreenParent(ScreenManager screenParent) {
        System.out.println("setScreenParent");
        myController = screenParent;
    }

    @Override
    public void setComponents() {
        System.out.println("setComponents");
        name_label.setText(myController.getUser().getName());
        age_label.setText(myController.getUser().getAge());
    }

}
