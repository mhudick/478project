/* Developer: Mark Donile
** Date: 2015.10.31
** Configuration Version: 1.0.0
*/

package controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.Node;

import java.util.HashMap;

public class HomeController extends GridPane implements ManagedScreen{

    private ScreenManager screenManager;
    private Node previousContent;
    //private ScreenManager homeViewManager;
    @FXML private ChoiceBox menuChoiceBox;
    @FXML private TextField searchTextField;
    @FXML private Button searchButton;
    @FXML private StackPane contentStackPane;
    private FoodsVBox foodsVBox = new FoodsVBox();
    private UserSummaryVBox userSummaryVBox = new UserSummaryVBox();

    public void setScreenManager(ScreenManager screenManager){
        this.screenManager = screenManager;
    }

    public void handleSearchButton(ActionEvent actionEvent){
        System.out.println("Search button clicked!");
    }

    public void handleMenuChoiceBox(ActionEvent actionEvent){
        System.out.println(menuChoiceBox.getValue().toString() + " was selected.");
        removeContent();
        String selectedContent = menuChoiceBox.getValue().toString();
        switch(selectedContent){
            case "Home":
                contentStackPane.getChildren().add(0, userSummaryVBox);
                break;
            case "Foods":
                contentStackPane.getChildren().add(0, foodsVBox);
        }
    }

    public void loadMenuChoiceBox(){
        //TODO create contentView enum and use it to populate the menuChoiceBox
        ObservableList<String> list = FXCollections.observableArrayList("Home", "Foods");
        menuChoiceBox.setItems(list);
        menuChoiceBox.setValue("Home");
    }

    @FXML
    private void initialize(){
        System.out.println("HomeController initialized.");
        /*
        ScreenManager homeViewManager = new ScreenManager();
        GridPane.setRowIndex(homeViewManager, 1);
        GridPane.setColumnIndex(homeViewManager, 0);
        GridPane.setColumnSpan(homeViewManager, 3);
        getChildren().add(homeViewManager);
        homeViewManager.loadScreen(Screen.FOODS, Screen.FOODS.getResourcePath());
        homeViewManager.loadScreen(Screen.USER_SUMMARY, Screen.USER_SUMMARY.getResourcePath());
        homeViewManager.show(Screen.USER_SUMMARY);
        */
        loadMenuChoiceBox();
        //TODO show user_summary.fxml in contentStackPane
    }

    public void removeContent(){
        if(contentStackPane.getChildren().size() != 0){
            setPreviousContent((Node) contentStackPane.getChildren().remove(0));
        }
    }

    public void setPreviousContent(Node previousContent){
        this.previousContent = previousContent;
    }

}
