package controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import models.Food;
import util.database.FoodData;
import util.database.FoodDataImpl;
import util.web.WebAccess;
import util.web.WebAccessImpl;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by Philip on 11/5/2015.
 */
public class SearchScreen extends VBox{

    WebAccess webAccess = new WebAccessImpl();
    FoodData foodData = new FoodDataImpl();
    HashMap<String,String> listMap;

    @FXML
    ListView<String> searchListView;
    @FXML
    Pane detailPane;
    @FXML
    Button detailButton;

    public SearchScreen(){
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
    }

    public void getSearchResults(String query){
        listMap = webAccess.searchForFood(query);
        ObservableList<String> listData = FXCollections.observableArrayList();
        Iterator it = listMap.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            System.out.println(pair.getKey() + " = " + pair.getValue());
            listData.add(pair.getKey().toString());
        }
        searchListView.setItems(listData);
    }

    @FXML
    public void handleBackButton(ActionEvent event){
        Food food = foodData.getFood("01038");
        System.out.println(food.toString());
    }
    @FXML
    public void handleDetailButton(ActionEvent event){
        System.out.println("Detail Button Pressed.");
        if(!detailPane.getChildren().isEmpty()){
            detailPane.getChildren().remove(0);
        }
        Food food = webAccess.getFood(listMap.get(searchListView.getSelectionModel().getSelectedItem()));
        detailPane.getChildren().add(0,new FoodDetailSubScreen(food));
    }
}
