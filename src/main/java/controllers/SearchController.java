package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

/**
 * Created by Philip on 11/5/2015.
 */
public class SearchController extends VBox{
    @FXML
    ListView<String> searchListView;
    @FXML
    Pane detailPane;

    public SearchController(){
        System.out.println("Recipe Constructor");
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/views/search_results.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);
        try{
            fxmlLoader.load();
        }
        catch(Exception e){
            System.out.println(e.toString());
        }
        detailPane.getChildren().add(0,new FoodCard());
    }

    @FXML
    public void handleSearchButton(ActionEvent event){
        System.out.println("Detail Button Pressed.");
    }
}
