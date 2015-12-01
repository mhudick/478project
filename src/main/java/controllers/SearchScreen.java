package controllers;

/* Developer: Philip Churchill
** Date: 2015.11.5
** Configuration Version: 1.0.0
*/

/**
 * This class is the controller for the SearchScreen. It provides a listView that
 * is populated with the search results returned from the USDA's Nutritional database.
 * When the user selects a food item from the list, the searchScreenCard is created and
 * displays basic info about the item selected.
 */

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import models.Food;
import util.web.WebAccess;
import util.web.WebAccessImpl;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class SearchScreen extends VBox{

    private WebAccess webAccess = new WebAccessImpl();
    private HashMap<String,String> listMap;

    @FXML
    ListView<String> searchListView;
    @FXML
    Pane foodPane;

    public SearchScreen(){
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
        searchListView.getItems().clear();
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
}
