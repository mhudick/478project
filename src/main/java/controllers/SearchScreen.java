package controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
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
public class SearchScreen extends VBox implements SessionControl, HomeControl{

    private WebAccess webAccess = new WebAccessImpl();
    private FoodData foodData = new FoodDataImpl();
    private HashMap<String,String> listMap;
    private HomeScreen homeScreen;
    private SessionManager sessionManager;

    @FXML
    ListView<String> searchListView;
    @FXML
    Pane foodPane;


    public SearchScreen(){
        System.out.println("Recipe Constructor");
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/views/search_screen.fxml"));
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
    public void handleMouseClick(MouseEvent arg0){
        System.out.println("clicked on " + searchListView.getSelectionModel().getSelectedItem().toString());
        Food food = webAccess.getFood(listMap.get(searchListView.getSelectionModel().getSelectedItem()));
        if(!foodPane.getChildren().isEmpty()){
            foodPane.getChildren().remove(0);
        }
        foodPane.getChildren().add(0, new SearchScreenCard(food));
    }

    @Override
    public void setSessionManager(SessionManager sessionManager) {
        this.sessionManager = sessionManager;
    }

    @Override
    public void setHomeScreen(HomeScreen homeScreen) {
        this.homeScreen = homeScreen;
    }
}
