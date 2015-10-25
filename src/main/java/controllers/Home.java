/* Developer: Mark Donile
** Date: 2015.10.18
** Configuration Version: 1.0.0
*/

package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class Home extends VBox {

    //CONSTANTS
    private static final String CHANGE_USER = "Change User";
    private static final String DAILY_TRACKER = "Daily Tracker";
    private static final String EXERCISE = "Exercise";
    private static final String FOODS = "Foods";
    private static final String HOME = "Home";
    private static final String RECIPES = "Recipes";
    private static final String WEIGH_IN = "Weigh-in";

    //fields
    @FXML private ChoiceBox menuChoiceBox;
    @FXML private Button searchButton;
    @FXML private TextField searchTextField;
    @FXML private StackPane contentStackPane;

    public Home(){
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/views/home.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try{
            fxmlLoader.load();
        }
        catch(Exception e){
            System.out.println(e.toString());
        }

        //Display the User Summary view when Home Screen is launched
        contentStackPane.getChildren().add(new UserSummary());
    }

    public void handleSearchButtonAction(ActionEvent event){
        System.out.println("Search button pressed!");
    }

    public void handleMenuChoiceBoxAction(ActionEvent event){
        //Remove current content
        contentStackPane.getChildren().removeAll();

        //Determine which page was selected by the user
        String selectedPage = menuChoiceBox.getValue().toString();

        //Display page selected by user
        switch(selectedPage){
            case HOME:
                contentStackPane.getChildren().add(new UserSummary());
                break;
            case FOODS:
                FoodsVBox foodsVBox = new FoodsVBox();
                foodsVBox.addFoods();
                contentStackPane.getChildren().add(foodsVBox);
                break;
            case RECIPES:
                contentStackPane.getChildren().add(new RecipesVBox());
                break;
            case DAILY_TRACKER:
                contentStackPane.getChildren().add(new DailyTrackerVBox());
                break;
            case WEIGH_IN:
                contentStackPane.getChildren().add(new WeighInVBox());
                break;
            case EXERCISE:
                contentStackPane.getChildren().add(new ExerciseVBox());
                break;
            case CHANGE_USER:
                contentStackPane.getChildren().add(new ChangeUserVBox());
                break;
            default:
                contentStackPane.getChildren().add(new UserSummary());
                break;
        }
    }
}