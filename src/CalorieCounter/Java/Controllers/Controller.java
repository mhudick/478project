package CalorieCounter.Java.Controllers;

import CalorieCounter.Java.Model.Food;
import CalorieCounter.Java.Model.SearchResponse;
import CalorieCounter.Java.Model.SearchResponseItem;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import javax.swing.text.TabableView;
import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Controller {

    SearchResponse currentList;
    Food currentFood;
    @FXML
    private TextField searchField;

    @FXML
    private Button myButton;

    @FXML
    private TableView<SearchResponseItem> listView;

    @FXML
    private TextArea textArea;

    @FXML
    private TextField details;

    @FXML
    private Button getDetails;

    @FXML
    private Button refreshButton;

    @FXML
    private Button saveButton;

    @FXML
    private ListView<String> databaseList;

    @FXML
    private Button deleteButton;

    @FXML
    private TextField deleteField;
    /*
    This method is called after the Loader retrieves the FXML file and will handle the events.
     */
    @FXML
    private void initialize(){
        //Takes text from field and uses it as the search term. Then it sets textArea.
        myButton.setOnAction((event) ->{

            currentList = new WebManager().webSearchFoods(searchField.getText());
            System.out.println(currentList.toString());

            ObservableList<SearchResponseItem> data = FXCollections.observableArrayList(currentList.getItem());
            System.out.println(data.toString());

            TableColumn ndbno = new TableColumn("NDBNO");
            ndbno.setCellValueFactory(new PropertyValueFactory<SearchResponseItem, String>("ndbno"));
            TableColumn name = new TableColumn("Name");
            name.setCellValueFactory(new PropertyValueFactory<SearchResponseItem,String>("name"));
            TableColumn fg = new TableColumn("Good Group");
            fg.setCellValueFactory(new PropertyValueFactory<SearchResponseItem, String>("group"));

            listView.setItems(data);
            listView.getColumns().addAll(ndbno, name, fg);
        });
        getDetails.setOnAction(event -> {

            currentFood = new WebManager().webFoodDetails(details.getText());
            textArea.setText(currentFood.toString());

        });

        saveButton.setOnAction(event1 -> {
            new DataManager().saveFood(currentFood);
        });

        refreshButton.setOnAction(event -> {
            List ls = new DataManager().getFoodList();
            System.out.println(ls.toString());
            ObservableList<String> data = FXCollections.observableArrayList(ls);
            databaseList.setItems(data);
        });

        deleteButton.setOnAction(event -> {
            new DataManager().deleteFood(Integer.parseInt(deleteField.getText()));
        });
    }
}
