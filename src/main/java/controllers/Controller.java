package controllers;

import models.Food;
import models.SearchItem;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import util.web.WebAccess;
import util.web.WebAccessImpl;
import java.util.List;

public class Controller {
    WebAccess webAccess = new WebAccessImpl();
    List<SearchItem> searchList;
    Food currentFood;
    @FXML
    private TextField searchField;

    @FXML
    private Button myButton;

    @FXML
    private TableView<SearchItem> listView;

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
            List<SearchItem> searchItemList = webAccess.searchForFood(searchField.getText());
            System.out.println(searchItemList.toString());

            TableColumn<SearchItem, String> idColumn = new TableColumn<SearchItem,String>("NDB no");
            TableColumn<SearchItem, String> nameColumn = new TableColumn<SearchItem,String>("Name");
            TableColumn<SearchItem, String> groupColumn = new TableColumn<SearchItem,String>("Food Group");

            idColumn.setCellValueFactory(new PropertyValueFactory<SearchItem, String>("ndbno"));
            nameColumn.setCellValueFactory(new PropertyValueFactory<SearchItem, String>("name"));
            groupColumn.setCellValueFactory(new PropertyValueFactory<SearchItem, String>("group"));

            listView.getColumns().addAll(idColumn, nameColumn, groupColumn);
            ObservableList<SearchItem> data = FXCollections.observableArrayList(searchItemList);
            listView.setItems(data);
        });

        getDetails.setOnAction(event -> {

        });

        saveButton.setOnAction(event1 -> {

        });

        refreshButton.setOnAction(event -> {

        });

        deleteButton.setOnAction(event -> {

        });
    }
}
